package kz.halykfinance.vote.service;

import kz.halykfinance.vote.controller.UserController;
import kz.halykfinance.vote.entity.Process;
import kz.halykfinance.vote.entity.Signers;
import kz.halykfinance.vote.repository.ProcessRepository;
import kz.halykfinance.vote.repository.SignersRepository;
import kz.halykfinance.vote.utils.ProcessStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {
    @Autowired
    ProcessRepository processRepository;
    @Autowired
    SignersRepository signersRepository;

    String ERROR_MESSAGE = "No such signer";

    public List<Process> getByStatus(ProcessStatusEnum status) {
        return processRepository.findByStatus(status);
    }

    public Signers checkSignerExistense(String iin){
        List<Signers> signers = signersRepository.getAll();
        for (Signers signer : signers){
            if (signer.getIin().equals(iin))
                return signer;
        } return null;
    }

    public String checkSignerExistens(String iin){
        if (!checkSignerExistense(iin).equals(null)){
            Signers signer = checkSignerExistense(iin);
        List<Process> process = processRepository.findProcessBySigners(signer);
        List<Process> finishedProcesses = processRepository.findProcessesByStatusAndSigners(ProcessStatusEnum.FINISHED,signer);
        List<Process> activeProcesses = processRepository.findProcessesByStatusAndSigners(ProcessStatusEnum.ACTIVE,signer);
        return "FINISHED PROCECSS " + finishedProcesses + "\t" +
                " ACTIVE PROCESSES " + activeProcesses;
        } return ERROR_MESSAGE;
    }
}
