package study.tangpoo.livecodingtest.dto.dataInformationPerDevice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataInformationPerDeviceRes {

    private Long id;
    private String serialNumber;
    private Double averageData;
}
