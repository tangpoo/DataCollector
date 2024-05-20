package study.tangpoo.livecodingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.tangpoo.livecodingtest.entity.DataDeviceEntity;

public interface DataDeviceRepository extends JpaRepository<DataDeviceEntity, Long> {

    boolean existsBySerialNumber(String serialNumber);
}
