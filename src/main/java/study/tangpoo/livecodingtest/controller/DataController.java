package study.tangpoo.livecodingtest.controller;

import static study.tangpoo.livecodingtest.message.Message.SUCCESS;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.tangpoo.livecodingtest.dto.ResponseDto;
import study.tangpoo.livecodingtest.dto.data.DataReq;
import study.tangpoo.livecodingtest.dto.data.DataRes;
import study.tangpoo.livecodingtest.service.DataService;

@Slf4j
@Tag(name = "Data API")
@RestController
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @PostMapping("/data")
    @Operation(summary = "데이터 등록")
    public ResponseEntity<ResponseDto<Void>> saveData(@RequestBody DataReq dataReq) {
        dataService.saveData(dataReq);

        return ResponseEntity.ok()
            .body(ResponseDto.<Void>builder()
                .message(SUCCESS)
                .build());
    }

    @GetMapping("/data/device")
    @Operation(summary = "데이터 수집 장치의 데이터 조회")
    public ResponseEntity<ResponseDto<DataRes>> getByDataDevice(
        @RequestParam String dataDeviceSerialNumber,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") LocalDateTime startTime,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") LocalDateTime endTime
    ) {
        DataRes byDataDevice = dataService.findByDataDevice(dataDeviceSerialNumber, startTime,
            endTime);

        return ResponseEntity.ok()
            .body(ResponseDto.<DataRes>builder()
                .message(SUCCESS)
                .data(byDataDevice)
                .build());
    }

    @GetMapping("/data/device/group")
    @Operation(summary = "데이터 수집 장치 그룹 데이터 조회")
    public ResponseEntity<ResponseDto<List<DataRes>>> getByStationGroup(
        @RequestParam String stationGroupSerialNumber,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") LocalDateTime startTime,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") LocalDateTime endTime
    ) {
        List<DataRes> byDataDeviceList = dataService.findByStationGroup(stationGroupSerialNumber,
            startTime,
            endTime);

        return ResponseEntity.ok()
            .body(ResponseDto.<List<DataRes>>builder()
                .message(SUCCESS)
                .data(byDataDeviceList)
                .build());
    }
}
