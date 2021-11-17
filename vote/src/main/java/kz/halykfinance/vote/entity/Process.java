package kz.halykfinance.vote.entity;

import kz.halykfinance.vote.utils.ProcessStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROCESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private ProcessStatusEnum status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Signers> signers;
}
