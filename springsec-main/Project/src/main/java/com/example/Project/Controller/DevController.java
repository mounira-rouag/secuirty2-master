package com.example.Project.Controller;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Dev;
import com.example.Project.Models.Maj;
import com.example.Project.Models.Sites;
import com.example.Project.Repositories.CDCRepository;
import com.example.Project.Repositories.DevRepository;
import com.example.Project.Repositories.SitesRepository;
import com.example.Project.Services.CDCServiceImpl;
import com.example.Project.Services.DevServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequestMapping("/api")
public class DevController {
    final private DevRepository devRepo;
    private final DevServiceImpl devServiceImpl;
    private final CDCServiceImpl cdcServiceImpl;
    private final SitesRepository siteRepo;
    private final CDCRepository cdcRepo;


    public DevController(DevRepository devRepo, DevServiceImpl devServiceImpl, CDCServiceImpl cdcServiceImpl, SitesRepository siteRepo, CDCRepository cdcRepo) {
        this.devRepo = devRepo;
        this.devServiceImpl = devServiceImpl;
        this.cdcServiceImpl = cdcServiceImpl;
        this.siteRepo = siteRepo;
        this.cdcRepo = cdcRepo;
    }


    @GetMapping("/all-dll")
    public List<Dev> getAllMarqueNames() {
        return devServiceImpl.getAllDev();
    }

    @GetMapping("/sites/all")
    public List<Sites> getAllSites() {
        return siteRepo.findAll();
    }

    @GetMapping("/cdc/all")
    public List<CDC> getAllCdc() {
        return cdcRepo.findAll();
    }

    @GetMapping("/dev/all")
    public List<Dev> getAllDevs() {
        return devRepo.findAll();
    }

    @GetMapping("/dev/{id}")
    public Optional<Dev> findDevById(@PathVariable int id) {
        return devServiceImpl.findById(id);
    }

    @GetMapping("/dev/by-cdc/{id}")
    public List<Dev> findDevByCDC(@PathVariable int id) {

        return devServiceImpl.getDevByCdcId(id);
    }

    @GetMapping("dev/filters")
    public List<Dev> getFilteredDevs(
            @RequestParam(value = "cdc", required = false) int idCdc
    ) {
        Optional<CDC> optionalCdc = cdcServiceImpl.findById(idCdc);
        if (optionalCdc.isPresent()) {
            CDC cdc = optionalCdc.get();  // Safe to call get() here
            return cdcServiceImpl.findDevByCdc(cdc);
        } else {
            // Handle the case where no CDC is found (e.g., return empty list or error message)
            return Collections.emptyList();  // Example: return an empty list
        }
    }

    @GetMapping("dev/dll-id")
    public List<Dev> getDevByDll(@RequestParam String dll){
        return devRepo.findByDll(dll);
    }
    }