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
public class DataDeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String serialNumber;

    @Column
    private String stationGroupSerial;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    public DataDeviceEntity(String serialNumber, String stationGroupSerial) {
        this.serialNumber = serialNumber;
        this.stationGroupSerial = stationGroupSerial;
    }
}
