package study.tangpoo.livecodingtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String serialNumber;

    @Column
    private int interval;

    @Column
    private String dateSet;

    @Column
    @CreatedDate
    private LocalDateTime recordedAt;

    public DataEntity(String serialNumber, int interval, String dateSet, LocalDateTime recordedAt) {
        this.serialNumber = serialNumber;
        this.interval = interval;
        this.dateSet = dateSet;
        this.recordedAt = recordedAt;
    }
}
