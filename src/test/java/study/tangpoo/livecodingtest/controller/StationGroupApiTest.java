package study.tangpoo.livecodingtest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import study.tangpoo.livecodingtest.ApiTest;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;

public class StationGroupApiTest extends ApiTest {

    @Test
    void 그룹등록() {

        final StationGroupReq request = StationGroupSteps.그룹등록요청_생성();

        final var response = StationGroupSteps.그룹등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
