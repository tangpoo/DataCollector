package study.tangpoo.livecodingtest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.tangpoo.livecodingtest.dto.data.DataReq;
import study.tangpoo.livecodingtest.entity.DataEntity;
import study.tangpoo.livecodingtest.repository.DataRepository;

@Service
@RequiredArgsConstructor
public class DataService {

    private final DataRepository dataRepository;

    public void saveData(DataReq dataReq) {
        List<DataEntity> dataEntityList = convertData(
            dataReq.getSerialNumber(),
            dataReq.getInterval(),
            dataReq.getDataSet(),
            dataReq.getRecorded_at());

        dataRepository.saveAll(dataEntityList);
    }

    private List<DataEntity> convertData(String serialNumber, Integer interval, String dataSet, LocalDateTime recordedAt){
        List<Integer> dataList = tokenize(dataSet);
        List<DataEntity> dataEntityList = new ArrayList<>();

        for(Integer data : dataList){
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

    private List<Integer> tokenize(String hexaData){
        List<Integer> dataList = new ArrayList<>();

        while(hexaData.length() >= 4){
            String substring = hexaData.substring(0, 4);
            hexaData = hexaData.substring(0, 4);

            Integer decimalValue = Integer.parseInt(substring, 16);
            dataList.add(decimalValue);
        }

        if(!hexaData.isEmpty()){
            Integer decimalValue = Integer.parseInt(hexaData, 16);
            dataList.add(decimalValue);
        }

        return dataList;
    }
}
