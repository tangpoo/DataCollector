package study.tangpoo.livecodingtest.dto.stationGroup;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StationGroupRes {

    private Long stationGroupId;
    private String serialNumber;
    private LocalDateTime createdAt;
}
