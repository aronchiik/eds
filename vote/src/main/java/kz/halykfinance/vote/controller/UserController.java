package kz.halykfinance.vote.controller;

import kz.halykfinance.vote.entity.Process;
import kz.halykfinance.vote.entity.Signers;
import kz.halykfinance.vote.repository.ProcessRepository;
import kz.halykfinance.vote.repository.SignersRepository;
import kz.halykfinance.vote.service.ProcessService;
import kz.halykfinance.vote.utils.ProcessStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private ProcessService processService;
    @Autowired
    private ProcessRepository processRepository;

    @GetMapping("login")
    public String logon(@RequestParam("iin") String iin, Model model) {
       String processes = processService.checkSignerExistens(iin);
       model.addAttribute("Signer", processes);
       //String method that divides processes into 2:activeProcesses and finishedProcesses
        System.out.println(processes);
      //  model.addAttribute("signerError", processes);
     //  model.addAttribute("finished processes", activeProcesses)
       // model.addAttribute("active processes",finishedProcesses)
       //model.addAtribute("Documents", processes);
        return "login";
    }

    @PostMapping("signing")
    //signing will go with Kalkan
    //or
    //we sign hash with another way


   /* public String signingProcess(){

    }*/

    @GetMapping("ky")
    public String getClientInf(@RequestParam("file") MultipartFile file){
    return "";
    }
}
