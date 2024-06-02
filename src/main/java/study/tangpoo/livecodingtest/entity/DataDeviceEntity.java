package study.tangpoo.livecodingtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(indexes = {@Index(name = "idx_station_group_serial", columnList = "station_group_serial")})
@NoArgsConstructor
public class DataDeviceEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String serialNumber;

    @Column
    private String stationGroupSerial;

    public DataDeviceEntity(String serialNumber, String stationGroupSerial) {
        this.serialNumber = serialNumber;
        this.stationGroupSerial = stationGroupSerial;
    }
}
