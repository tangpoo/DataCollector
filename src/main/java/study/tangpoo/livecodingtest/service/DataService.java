package study.tangpoo.livecodingtest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.tangpoo.livecodingtest.dto.data.DataReq;
import study.tangpoo.livecodingtest.dto.data.DataRes;
import study.tangpoo.livecodingtest.entity.DataEntity;
import study.tangpoo.livecodingtest.repository.DataDeviceRepository;
import study.tangpoo.livecodingtest.repository.DataQueryRepository;
import study.tangpoo.livecodingtest.repository.DataRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DataService {

    private final DataRepository dataRepository;
    private final DataQueryRepository dataQueryRepository;
    private final DataDeviceRepository dataDeviceRepository;

    public void saveData(DataReq dataReq) {
        List<DataEntity> dataEntityList = convertData(
            dataReq.getSerialNumber(),
            dataReq.getInterval(),
            dataReq.getDataSet(),
            dataReq.getRecorded_at());

        dataRepository.saveAll(dataEntityList);
    }

    @Transactional(readOnly = true)
    public DataRes findByDataDevice(String dataDeviceSerialNumber, LocalDateTime startDate,
        LocalDateTime endDate) {

        return dataQueryRepository.findByDataDevice(dataDeviceSerialNumber, startDate, endDate);
    }

    @Transactional(readOnly = true)
    public List<DataRes> findByStationGroup(String stationGroupSerialNumber,
        LocalDateTime startDate,
        LocalDateTime endDate) {
        return dataQueryRepository.findByStationGroup(stationGroupSerialNumber, startDate, endDate);
    }


    private List<DataEntity> convertData(String serialNumber, Integer interval, String dataSet,
        LocalDateTime recordedAt) {
        List<Integer> dataList = tokenize(dataSet);
        List<DataEntity> dataEntityList = new ArrayList<>();

        for (Integer data : dataList) {
            dataEntityList.add(new DataEntity(
                serialNumber,
                interval,
                data,
                recordedAt
            ));

            recordedAt = recordedAt.plusMinutes(interval);
        }

        return dataEntityList;
    }

    private List<Integer> tokenize(String hexaData) {
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < hexaData.length(); i += 4) {
            if (i + 4 <= hexaData.length()) {
                String substring = hexaData.substring(i, i + 4);
                Integer decimalValue = Integer.parseInt(substring, 16);
                dataList.add(decimalValue);
            }
        }

//        while(hexaData.length() >= 4){
//            String substring = hexaData.substring(0, 4);
//            hexaData = hexaData.substring(0, 4);
//
//            Integer decimalValue = Integer.parseInt(substring, 16);
//            dataList.add(decimalValue);
//        }

//        if(!hexaData.isEmpty()){
//            Integer decimalValue = Integer.parseInt(hexaData, 16);
//            dataList.add(decimalValue);
//        }

        return dataList;
    }
}
