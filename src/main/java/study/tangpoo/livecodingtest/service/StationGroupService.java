package study.tangpoo.livecodingtest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupRes;
import study.tangpoo.livecodingtest.entity.StationGroupEntity;
import study.tangpoo.livecodingtest.repository.StationGroupRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class StationGroupService {

    private final StationGroupRepository stationGroupRepository;

    public StationGroupRes saveStationGroup(StationGroupReq stationGroupReq) {

        if (stationGroupRepository.existsBySerialNumber(stationGroupReq.getStationGroupSerial())) {
            throw new DataIntegrityViolationException("중복된 데이터 수집 장치 그룹입니다.");
        }

        StationGroupEntity stationGroupEntity = new StationGroupEntity(
            stationGroupReq.getStationGroupSerial());

        StationGroupEntity saveStationGroupEntity = stationGroupRepository.save(stationGroupEntity);

        return new StationGroupRes(saveStationGroupEntity.getId(),
            saveStationGroupEntity.getSerialNumber(), saveStationGroupEntity.getCreatedAt());
    }
}
