package study.tangpoo.livecodingtest.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    @CreatedDate
    private LocalDateTime createdAt;

    public BaseTime(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BaseTime() {
        this(null);
    }
}
