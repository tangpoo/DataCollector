package study.tangpoo.livecodingtest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto<T> {

    private String Message;
    private T data;
}
