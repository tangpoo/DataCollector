package study.tangpoo.livecodingtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@NoArgsConstructor
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String serialNumber;

    @Column
    private Integer timeInterval;

    @Column
    private Integer dataSet;

    @Column
    private LocalDateTime recordedAt;

    public DataEntity(String serialNumber, Integer interval, Integer dataSet, LocalDateTime recordedAt) {
        this.serialNumber = serialNumber;
        this.timeInterval = interval;
        this.dataSet = dataSet;
        this.recordedAt = recordedAt;
    }
}
