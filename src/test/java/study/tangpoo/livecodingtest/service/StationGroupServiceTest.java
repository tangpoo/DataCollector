package study.tangpoo.livecodingtest.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import study.tangpoo.livecodingtest.controller.StationGroupSteps;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupRes;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
public class StationGroupServiceTest {

    @Autowired
    private StationGroupService stationGroupService;

    @Test
    @Transactional
    void 그룹등록() {
        final StationGroupReq request = StationGroupSteps.그룹등록요청_생성();
        final StationGroupRes response = stationGroupService.saveStationGroup(request);

        assertThat(response.getStationGroupId()).isNotNull();
        assertThat(response.getSerialNumber()).isEqualTo(request.getStationGroupSerial());
    }

}
