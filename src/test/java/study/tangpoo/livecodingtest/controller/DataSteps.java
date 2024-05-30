package study.tangpoo.livecodingtest.controller;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.time.LocalDateTime;
import org.springframework.http.MediaType;
import study.tangpoo.livecodingtest.dto.data.DataReq;

public class DataSteps {

    public static DataReq 데이터등록요청_생성() {
        final String serialNumber = "serialNumber";
        final Integer interval = 10;
        final String dataSet = "2710";  // 10000 = 0x2710
        final LocalDateTime recorded_at = LocalDateTime.parse("2024-05-30T10:31:00.000000");
        return new DataReq(serialNumber, interval, dataSet, recorded_at);
    }

    static ExtractableResponse<Response> 데이터등록요청(final DataReq request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/data")
            .then().log().all()
            .extract();
    }

    static ExtractableResponse<Response> 장치데이터조회(final String dataDeviceSerialNumber,
        final String startTime, final String endTime) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .queryParam("dataDeviceSerialNumber", dataDeviceSerialNumber)
            .queryParam("startTime", startTime)
            .queryParam("endTime", endTime)
            .when()
            .get("/data/device")
            .then().log().all()
            .extract();
    }

    static ExtractableResponse<Response> 장치그룹_데이터_조회(final String stationGroupSerialNumber,
        final String startTime, final String endTime) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .queryParam("stationGroupSerialNumber", stationGroupSerialNumber)
            .queryParam("startTime", startTime)
            .queryParam("endTime", endTime)
            .when()
            .get("/data/device/group")
            .then().log().all()
            .extract();
    }
}
