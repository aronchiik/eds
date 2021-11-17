package kz.halykfinance.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SIGNERS", indexes = {@Index(name = "process_index1", columnList = "iin")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Signers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "process_id")
    private Long processId;

    @Column(name = "fio")
    private String fio;

    @Column(name = "iin")
    private String iin;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}
