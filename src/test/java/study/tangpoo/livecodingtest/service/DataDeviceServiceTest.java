package study.tangpoo.livecodingtest.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import study.tangpoo.livecodingtest.controller.DataDeviceSteps;
import study.tangpoo.livecodingtest.controller.StationGroupSteps;
import study.tangpoo.livecodingtest.dto.dataDevice.DataDeviceReq;
import study.tangpoo.livecodingtest.dto.dataDevice.DataDeviceRes;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
public class DataDeviceServiceTest {

    @Autowired
    private DataDeviceService dataDeviceService;

    @Autowired
    private StationGroupService stationGroupService;

    @Test
    @Transactional
    void 장치등록() {
        stationGroupService.saveStationGroup(StationGroupSteps.그룹등록요청_생성());
        final DataDeviceReq request = DataDeviceSteps.장치등록요청_생성();

        final DataDeviceRes response = dataDeviceService.saveDataDevice(request);

        assertThat(response.getDeviceId()).isNotNull();
        assertThat(response.getSerialNumber()).isEqualTo(request.getSerialNumber());
    }

}
