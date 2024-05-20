package study.tangpoo.livecodingtest.controller;

import static study.tangpoo.livecodingtest.message.Message.SUCCESS;

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

@RestController
@RequiredArgsConstructor
public class StationGroupController {

    private final StationGroupService stationGroupService;

    @PostMapping("/station/group")
    public ResponseEntity<ResponseDto<StationGroupRes>> saveStationGroup(
        @RequestBody StationGroupReq stationGroupReq) {

        StationGroupRes stationGroupRes = stationGroupService.saveStationGroup(stationGroupReq);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResponseDto.<StationGroupRes>builder()
                .data(stationGroupRes)
                .Message(SUCCESS)
                .build());
    }
}
