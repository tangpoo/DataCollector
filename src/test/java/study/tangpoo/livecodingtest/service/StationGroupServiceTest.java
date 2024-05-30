package study.tangpoo.livecodingtest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;

@SpringBootTest
public class StationGroupServiceTest {

    @Autowired
    private StationGroupService stationGroupService;

    @Test
    @Transactional
    void 그룹등록() {
        final String serialNumber = "0xa";
        final StationGroupReq request = new StationGroupReq(serialNumber);
        stationGroupService.saveStationGroup(request);
    }
}
