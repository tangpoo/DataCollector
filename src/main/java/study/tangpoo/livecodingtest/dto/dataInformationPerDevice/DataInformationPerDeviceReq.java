package study.tangpoo.livecodingtest.dto.dataInformationPerDevice;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataInformationPerDeviceReq {

    private String serialNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
