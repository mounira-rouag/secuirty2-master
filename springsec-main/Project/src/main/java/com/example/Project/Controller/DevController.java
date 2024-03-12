package com.example.Project.Controller;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Dev;
import com.example.Project.Models.Maj;
import com.example.Project.Models.Sites;
import com.example.Project.Repositories.CDCRepository;
import com.example.Project.Repositories.SitesRepository;
import com.example.Project.Services.DevServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequestMapping("/api")
public class DevController {

private final DevServiceImpl devServiceImpl;
private final SitesRepository siteRepo;
private final CDCRepository cdcRepo;


    public DevController(DevServiceImpl devServiceImpl, SitesRepository siteRepo, CDCRepository cdcRepo) {
        this.devServiceImpl = devServiceImpl;
        this.siteRepo = siteRepo;
        this.cdcRepo = cdcRepo;
    }


    @GetMapping("/all-dll")
    public List<Dev> getAllMarqueNames() {
        return devServiceImpl.getAllDev();    }

    @GetMapping("/sites/all")
    public List<Sites> getAllSites() {
        return siteRepo.findAll();
    }

    @GetMapping("/cdc/all")
    public List<CDC> getAllCdc() {
        return cdcRepo.findAll();
    }
}




