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
import study.tangpoo.livecodingtest.dto.data.DataReq;
import study.tangpoo.livecodingtest.service.DataService;

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
}
