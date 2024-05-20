package study.tangpoo.livecodingtest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import study.tangpoo.livecodingtest.entity.StationGroupEntity;

public interface StationGroupRepository extends JpaRepository<StationGroupEntity, Long> {

    Optional<StationGroupEntity> findBySerialNumber(String serialNumber);
    boolean existsBySerialNumber(String serialNumber);
}
