package study.tangpoo.livecodingtest.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import study.tangpoo.livecodingtest.entity.WhiteIp;

@Repository
public interface WhiteIpRepository extends CrudRepository<WhiteIp,Long> {
    Optional<WhiteIp> findByAccessIp(String ip);
}
