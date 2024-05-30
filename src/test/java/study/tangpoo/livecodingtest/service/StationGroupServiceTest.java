package study.tangpoo.livecodingtest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.tangpoo.livecodingtest.controller.StationGroupSteps;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;

@SpringBootTest
public class StationGroupServiceTest {

    @Autowired
    private StationGroupService stationGroupService;

    @Test
    @Transactional
    void 그룹등록() {
        final StationGroupReq request = StationGroupSteps.그룹등록요청_생성();
        stationGroupService.saveStationGroup(request);
    }

}
