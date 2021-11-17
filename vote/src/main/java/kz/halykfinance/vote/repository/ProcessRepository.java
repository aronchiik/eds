package kz.halykfinance.vote.repository;

import kz.halykfinance.vote.entity.Process;
import kz.halykfinance.vote.entity.Signers;
import kz.halykfinance.vote.utils.ProcessStatusEnum;
import org.apache.tomcat.jni.Proc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcessRepository extends CrudRepository<Process, Long> {

    List<Process> findAll();
    List<Process> findByStatus(ProcessStatusEnum status);
    List<Process> findProcessesByStatusAndSigners(ProcessStatusEnum status,Signers signers);
    List<Process> findProcessBySigners(Signers signers);

}
