package study.tangpoo.livecodingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.tangpoo.livecodingtest.entity.DataEntity;

public interface DataRepository extends JpaRepository<DataEntity, Long> {

    boolean existsByDataSet(String dataSet);
}
