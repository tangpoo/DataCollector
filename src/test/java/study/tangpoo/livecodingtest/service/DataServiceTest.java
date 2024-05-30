package study.tangpoo.livecodingtest.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import study.tangpoo.livecodingtest.controller.DataDeviceSteps;
import study.tangpoo.livecodingtest.controller.DataSteps;
import study.tangpoo.livecodingtest.controller.StationGroupSteps;
import study.tangpoo.livecodingtest.dto.data.DataReq;
import study.tangpoo.livecodingtest.dto.data.DataRes;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
public class DataServiceTest {

    @Autowired
    private DataService dataService;
    @Autowired
    private DataDeviceService dataDeviceService;
    @Autowired
    private StationGroupService stationGroupService;

    @Test
    @Transactional
    void 데이터등록() {
        final DataReq request = DataSteps.데이터등록요청_생성();

        dataService.saveData(request);
    }

    @Test
    @Transactional(readOnly = true)
    void 데이터장치_데이터조회() {
        stationGroupService.saveStationGroup(StationGroupSteps.그룹등록요청_생성());
        dataDeviceService.saveDataDevice(DataDeviceSteps.장치등록요청_생성());
        dataService.saveData(DataSteps.데이터등록요청_생성());

        String dataDeviceSerialNumber = "serialNumber";
        LocalDateTime startTime = LocalDateTime.parse("2024-05-30T10:30:00.000000");
        LocalDateTime endTime = LocalDateTime.parse("2024-05-30T10:40:00.000000");

        final DataRes response = dataService.findByDataDevice(dataDeviceSerialNumber, startTime,
            endTime);

        assertThat(response.getId()).isNotNull();
        assertThat(response.getSerialNumber()).isEqualTo(dataDeviceSerialNumber);
        assertThat(response.getAverageData()).isEqualTo(10000.0);
    }

    @Test
    @Transactional(readOnly = true)
    void 장치그룹_데이터조회() {
        stationGroupService.saveStationGroup(StationGroupSteps.그룹등록요청_생성());
        dataDeviceService.saveDataDevice(DataDeviceSteps.장치등록요청_생성());
        dataService.saveData(DataSteps.데이터등록요청_생성());

        String stationGroupSerialNumber = "stationGroupSerial";
        LocalDateTime startTime = LocalDateTime.parse("2024-05-30T10:30:00.000000");
        LocalDateTime endTime = LocalDateTime.parse("2024-05-30T10:40:00.000000");

        final List<DataRes> response = dataService.findByStationGroup(
            stationGroupSerialNumber, startTime,
            endTime);

        assertThat(response.get(0).getId()).isNotNull();
        assertThat(response.get(0).getAverageData()).isEqualTo(10000.0);
    }
}
