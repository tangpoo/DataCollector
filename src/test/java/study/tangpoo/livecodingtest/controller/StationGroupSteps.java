package study.tangpoo.livecodingtest.controller;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;

public class StationGroupSteps {

    public static StationGroupReq 그룹등록요청_생성() {
        final String serialNumber = "stationGroupSerial";
        return new StationGroupReq(serialNumber);
    }

    public static ExtractableResponse<Response> 그룹등록요청(final StationGroupReq request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/station/group")
            .then().log().all()
            .extract();
    }
}
