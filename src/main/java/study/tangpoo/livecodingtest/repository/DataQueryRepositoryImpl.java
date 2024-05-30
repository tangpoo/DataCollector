package study.tangpoo.livecodingtest.repository;

import static study.tangpoo.livecodingtest.entity.QDataDeviceEntity.dataDeviceEntity;
import static study.tangpoo.livecodingtest.entity.QDataEntity.dataEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import study.tangpoo.livecodingtest.dto.data.DataRes;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DataQueryRepositoryImpl implements DataQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public DataRes findByDataDevice(String serialNumber, LocalDateTime startDate,
        LocalDateTime endDate) {

        Double average = queryFactory
            .select(dataEntity.dataSet.avg())
            .from(dataEntity)
            .where(dataEntity.serialNumber.eq(serialNumber),
                dataEntity.recordedAt.between(startDate, endDate))
            .fetchOne();

        if(average == null){
            throw new EntityNotFoundException("조건에 맞는 데이터가 존재하지 않습니다.");
        }

        average = Math.round(average * 10.0) / 10.0;

        return queryFactory
            .select(Projections.constructor(DataRes.class,
                dataDeviceEntity.id,
                dataDeviceEntity.serialNumber,
                Expressions.constant(average)
            ))
            .from(dataDeviceEntity)
            .where(dataDeviceEntity.serialNumber.eq(serialNumber))
            .fetchOne();
    }

    @Override
    public List<DataRes> findByStationGroup(String stationGroupSerialNumber,
        LocalDateTime startDate,
        LocalDateTime endDate) {

        Double average = queryFactory
            .select(dataEntity.dataSet.avg())
            .from(dataEntity)
            .leftJoin(dataDeviceEntity)
            .on(dataEntity.serialNumber.eq(dataDeviceEntity.serialNumber))
            .where(dataDeviceEntity.stationGroupSerial.eq(stationGroupSerialNumber),
                (dataEntity.recordedAt.between(startDate, endDate)))
            .fetchOne();

        if(average == null){
            throw new EntityNotFoundException("조건에 맞는 데이터가 존재하지 않습니다.");
        }

        average = Math.round(average * 10.0) / 10.0;

        return queryFactory
            .select(Projections.constructor(DataRes.class,
                dataDeviceEntity.id,
                dataDeviceEntity.serialNumber,
                Expressions.constant(average)
            ))
            .from(dataDeviceEntity)
            .where(dataDeviceEntity.stationGroupSerial.eq(stationGroupSerialNumber))
            .fetch();
    }
}
