package study.tangpoo.livecodingtest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import study.tangpoo.livecodingtest.ApiTest;

public class DataDeviceApiTest extends ApiTest {

    @Test
    void 장치등록() {
        StationGroupSteps.그룹등록요청(StationGroupSteps.그룹등록요청_생성());
        final var request = DataDeviceSteps.장치등록요청_생성();
        final ExtractableResponse<Response> response = DataDeviceSteps.장치등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
