package study.tangpoo.livecodingtest.repository;

import java.time.LocalDateTime;
import java.util.List;
import study.tangpoo.livecodingtest.dto.data.DataRes;

public interface DataQueryRepository {

    DataRes findByDataDevice(String dataDeviceSerialNumber, LocalDateTime startDate,
        LocalDateTime endDate);

    List<DataRes> findByStationGroup(String stationGroupSerialNumber, LocalDateTime startDate,
        LocalDateTime endDate);
}
