package study.tangpoo.livecodingtest.service;

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

        DataEntity dataEntity = new DataEntity(dataReq.getSerialNumber(), dataReq.getInterval(),
            dataReq.getDataSet(), dataReq.getRecorded_at());

        DataEntity saveDataEntity = dataRepository.save(dataEntity);
    }
}
