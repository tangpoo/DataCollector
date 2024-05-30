package study.tangpoo.livecodingtest.controller;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;
import study.tangpoo.livecodingtest.dto.dataDevice.DataDeviceReq;

public class DataDeviceSteps {

    public static DataDeviceReq 장치등록요청_생성() {
        final String serialNumber = "serialNumber";
        final String stationGroupSerial = "stationGroupSerial";
        return new DataDeviceReq(serialNumber, stationGroupSerial);
    }

    public static ExtractableResponse<Response> 장치등록요청(final DataDeviceReq request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/data/device")
            .then().log().all()
            .extract();
    }
}
