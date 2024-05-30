package study.tangpoo.livecodingtest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import study.tangpoo.livecodingtest.ApiTest;
import study.tangpoo.livecodingtest.dto.data.DataReq;

public class DataApiTest extends ApiTest {

    @Test
    void 데이터등록() {
        StationGroupSteps.그룹등록요청(StationGroupSteps.그룹등록요청_생성());
        DataDeviceSteps.장치등록요청(DataDeviceSteps.장치등록요청_생성());
        final DataReq request = DataSteps.데이터등록요청_생성();

        final var response = DataSteps.데이터등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 장치_데이터_조회() {
        StationGroupSteps.그룹등록요청(StationGroupSteps.그룹등록요청_생성());
        DataDeviceSteps.장치등록요청(DataDeviceSteps.장치등록요청_생성());
        DataSteps.데이터등록요청(DataSteps.데이터등록요청_생성());

        String dataDeviceSerialNumber = "serialNumber";
        String startTime = "2024-05-30 10:30:00.000000";
        String endTime = "2024-05-30 10:40:00.000000";

        final var response = DataSteps.장치데이터조회(dataDeviceSerialNumber, startTime,
            endTime);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void 장치그룹_데이터_조회() {
        StationGroupSteps.그룹등록요청(StationGroupSteps.그룹등록요청_생성());
        DataDeviceSteps.장치등록요청(DataDeviceSteps.장치등록요청_생성());
        DataSteps.데이터등록요청(DataSteps.데이터등록요청_생성());

        String stationGroupSerialNumber = "stationGroupSerial";
        String startTime = "2024-05-30 10:30:00.000000";
        String endTime = "2024-05-30 10:40:00.000000";

        final var response = DataSteps.장치그룹_데이터_조회(stationGroupSerialNumber,
            startTime, endTime);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
