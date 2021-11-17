package kz.halykfinance.vote.service;

import kz.halykfinance.vote.entity.Process;
import kz.halykfinance.vote.entity.Signers;
import kz.halykfinance.vote.repository.ProcessRepository;
import kz.halykfinance.vote.repository.SignersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private SignersRepository signersRepository;

    public HashMap<Integer,List> getProcessInfo(){
        List<Process> processList = processRepository.findAll();
        List<String> processInfo = new ArrayList<>();
        HashMap<Integer, List> processesMap = new HashMap<>();
        Integer i = 0;
        for (Process process :  processList){
            processesMap.put(i, Collections.singletonList(processInfo.add(process.getName())));
            processesMap.put(i, Collections.singletonList(processInfo.add(process.getDescription())));
            i++;
        }
        return processesMap;
    }
    public List<String> getSigners(){
        List<Signers> signers = signersRepository.getAll();
        List<String> signersName = new ArrayList<>();
        for (Signers signer : signers){
            signersName.add(signer.getFio());
        }return signersName;
    }
}
