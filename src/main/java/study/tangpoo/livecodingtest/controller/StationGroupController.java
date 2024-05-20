package study.tangpoo.livecodingtest.controller;

import static study.tangpoo.livecodingtest.message.Message.SUCCESS;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.tangpoo.livecodingtest.dto.ResponseDto;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupReq;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupRes;
import study.tangpoo.livecodingtest.service.StationGroupService;

@Tag(name = "StationGroup API")
@RestController
@RequiredArgsConstructor
public class StationGroupController {

    private final StationGroupService stationGroupService;

    @PostMapping("/station/group")
    @Operation(summary = "데이터 수집 장치 그룹 등록")
    public ResponseEntity<ResponseDto<StationGroupRes>> saveStationGroup(
        @RequestBody StationGroupReq stationGroupReq) {

        StationGroupRes stationGroupRes = stationGroupService.saveStationGroup(stationGroupReq);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResponseDto.<StationGroupRes>builder()
                .data(stationGroupRes)
                .message(SUCCESS)
                .build());
    }
}
