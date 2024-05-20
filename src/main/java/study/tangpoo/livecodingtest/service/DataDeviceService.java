package study.tangpoo.livecodingtest.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import study.tangpoo.livecodingtest.dto.dataDevice.DataDeviceReq;
import study.tangpoo.livecodingtest.dto.dataDevice.DataDeviceRes;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupRes;
import study.tangpoo.livecodingtest.entity.DataDeviceEntity;
import study.tangpoo.livecodingtest.entity.StationGroupEntity;
import study.tangpoo.livecodingtest.repository.DataDeviceRepository;
import study.tangpoo.livecodingtest.repository.StationGroupRepository;

@Service
@RequiredArgsConstructor
public class DataDeviceService {

    private final DataDeviceRepository dataDeviceRepository;
    private final StationGroupRepository stationGroupRepository;

    public DataDeviceRes saveDataDevice(DataDeviceReq dataDeviceReq) {

        DataDeviceEntity dataDeviceEntity = new DataDeviceEntity(dataDeviceReq.getSerialNumber(), dataDeviceReq.getStationGroupSerial());

        if(dataDeviceRepository.existsBySerialNumber(dataDeviceEntity.getSerialNumber())){
            throw new DataIntegrityViolationException("중복된 데이터 수집 장치입니다.");
        }

        StationGroupEntity stationGroupEntity = stationGroupRepository.findBySerialNumber(
            dataDeviceEntity.getSerialNumber()).orElseThrow(
            () -> new EntityNotFoundException("시리얼 넘버의 데이터 수집 장치 그룹이 존재하지 않습니다.")
        );

        DataDeviceEntity saveDataDeviceEntity = dataDeviceRepository.save(dataDeviceEntity);

        StationGroupRes stationGroupRes = new StationGroupRes(stationGroupEntity.getId(),
            stationGroupEntity.getSerialNumber(), stationGroupEntity.getCreatedAt());

        return new DataDeviceRes(
            saveDataDeviceEntity.getId(),
            saveDataDeviceEntity.getSerialNumber(),
            stationGroupRes,
            saveDataDeviceEntity.getCreatedAt()
        );
    }
}
