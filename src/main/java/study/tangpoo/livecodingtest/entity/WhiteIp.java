package study.tangpoo.livecodingtest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_ACCESS_IP_GENERATOR", sequenceName = "SEQ_ACCESS_IP", initialValue = 1, allocationSize = 1)
public class WhiteIp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCESS_IP_GENERATOR")
    @Column(name = "rec_key", columnDefinition = "int8 DEFAULT nextval('SEQ_ACCESS_IP'::regclass)")
    private Long recKey;

    @Column(name = "access_ip", length = 20)
    private String accessIp;

    @Column(name = "access_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime accessDate;
}
