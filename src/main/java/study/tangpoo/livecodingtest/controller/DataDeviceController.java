package study.tangpoo.livecodingtest.controller;

import static study.tangpoo.livecodingtest.message.Message.SUCCESS;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.tangpoo.livecodingtest.dto.ResponseDto;
import study.tangpoo.livecodingtest.dto.dataDevice.DataDeviceReq;
import study.tangpoo.livecodingtest.dto.dataDevice.DataDeviceRes;
import study.tangpoo.livecodingtest.service.DataDeviceService;

@RestController
@RequiredArgsConstructor
public class DataDeviceController {

    private final DataDeviceService dataDeviceService;

    @PostMapping("/data/device")
    public ResponseEntity<ResponseDto<DataDeviceRes>> saveDataDevice(
        @RequestBody DataDeviceReq dataDeviceReq) {

        DataDeviceRes dataDeviceRes = dataDeviceService.saveDataDevice(dataDeviceReq);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResponseDto.<DataDeviceRes>builder()
                .data(dataDeviceRes)
                .Message(SUCCESS)
                .build());
    }
}
