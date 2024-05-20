package study.tangpoo.livecodingtest.dto.dataInformationPerDeviceGroup;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataInformationPerDeviceGroupReq {

    private String stationGroupSerial;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
