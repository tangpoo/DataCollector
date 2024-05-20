package study.tangpoo.livecodingtest.dto.data;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataReq {

    private String serialNumber;
    private Integer interval;
    private String dataSet;
    private LocalDateTime recorded_at;
}
