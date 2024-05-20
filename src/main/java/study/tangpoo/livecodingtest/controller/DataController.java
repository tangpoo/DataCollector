package study.tangpoo.livecodingtest.controller;

import static study.tangpoo.livecodingtest.message.Message.SUCCESS;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.tangpoo.livecodingtest.dto.ResponseDto;
import study.tangpoo.livecodingtest.dto.data.DataReq;
import study.tangpoo.livecodingtest.service.DataService;

@RestController
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @PostMapping("/data")
    public ResponseEntity<ResponseDto<Void>> saveData(DataReq dataReq) {
        dataService.saveData(dataReq);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResponseDto.<Void>builder()
                .Message(SUCCESS)
                .build());
    }
}
