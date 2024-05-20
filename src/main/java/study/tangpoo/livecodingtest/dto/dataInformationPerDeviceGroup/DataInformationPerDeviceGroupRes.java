package study.tangpoo.livecodingtest.dto.dataInformationPerDeviceGroup;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import study.tangpoo.livecodingtest.dto.dataInformationPerDevice.DataInformationPerDeviceRes;

@Getter
@AllArgsConstructor
public class DataInformationPerDeviceGroupRes {

    private List<DataInformationPerDeviceRes> dataInformationPerDeviceResList;
}
