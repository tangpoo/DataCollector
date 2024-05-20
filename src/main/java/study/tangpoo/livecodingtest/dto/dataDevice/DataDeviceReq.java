package study.tangpoo.livecodingtest.dto.dataDevice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.tangpoo.livecodingtest.entity.DataDeviceEntity;

@Getter
@AllArgsConstructor
public class DataDeviceReq {

    private String serialNumber;
    private String stationGroupSerial;

    public DataDeviceEntity toEntity() {
        return new DataDeviceEntity(
            this.serialNumber,
            this.stationGroupSerial
        );
    }
}
