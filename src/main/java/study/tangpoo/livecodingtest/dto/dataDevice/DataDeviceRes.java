package study.tangpoo.livecodingtest.dto.dataDevice;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import study.tangpoo.livecodingtest.dto.stationGroup.StationGroupRes;

@Getter
@AllArgsConstructor
public class DataDeviceRes {

    private Long deviceId;
    private String serialNumber;
    private StationGroupRes stationGroupRes;
    private LocalDateTime createdAt;
}
