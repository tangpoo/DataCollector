package study.tangpoo.livecodingtest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupRes;
import study.tangpoo.livecodingtest.entity.StationGroupEntity;
import study.tangpoo.livecodingtest.repository.StationGroupRepository;

@Service
@RequiredArgsConstructor
public class StationGroupService {

    private final StationGroupRepository stationGroupRepository;

    public StationGroupRes saveStationGroup(StationGroupReq stationGroupReq) {

        StationGroupEntity stationGroupEntity = new StationGroupEntity(
            stationGroupReq.getStationGroupSerial());

        StationGroupEntity saveStationGroupEntity = stationGroupRepository.save(stationGroupEntity);

        return new StationGroupRes(saveStationGroupEntity.getId(),
            saveStationGroupEntity.getSerialNumber(), saveStationGroupEntity.getCreatedAt());
    }
}
