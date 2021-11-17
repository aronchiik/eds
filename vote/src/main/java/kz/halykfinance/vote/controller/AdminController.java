package kz.halykfinance.vote.controller;

import kz.halykfinance.vote.entity.Process;
import kz.halykfinance.vote.repository.ProcessRepository;
import kz.halykfinance.vote.service.AdminService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.util.*;

@Controller
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private ProcessRepository processRepository;
    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String getAdminPage(Model model){
       model.addAttribute("",adminService.getProcessInfo()) ;
        model.addAttribute("",adminService.getSigners());
        return "admin";
    }
    //submit the admin form
    //then system will generate some which eventally will be signed by signers
//    @PostMapping("/generateHash")
//    public String generateHash(@RequestBody("document") //some json object
//                                ){
//
//    }
}
