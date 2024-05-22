package study.tangpoo.livecodingtest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import study.tangpoo.livecodingtest.entity.DataDeviceEntity;

public interface DataDeviceRepository extends JpaRepository<DataDeviceEntity, Long> {

    boolean existsBySerialNumber(String serialNumber);

    Optional<DataDeviceEntity> findBySerialNumber(String dataDeviceSerialNumber);
}
