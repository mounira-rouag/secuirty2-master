package com.example.Project.Controller;

import com.example.Project.Models.*;
import com.example.Project.Repositories.CDCRepository;
import com.example.Project.Repositories.DevRepository;
import com.example.Project.Repositories.MarqueRepository;
import com.example.Project.Repositories.SitesRepository;
import com.example.Project.Services.CDCServiceImpl;
import com.example.Project.Services.DevServiceImpl;
import com.example.Project.Services.VehiculeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private final MarqueRepository marqueRepo;
    private final VehiculeServiceImpl vehiculeServiceImpl;


    public DevController(DevRepository devRepo, DevServiceImpl devServiceImpl, CDCServiceImpl cdcServiceImpl, SitesRepository siteRepo, CDCRepository cdcRepo, MarqueRepository marqueRepo, VehiculeServiceImpl vehiculeServiceImpl) {
        this.devRepo = devRepo;
        this.devServiceImpl = devServiceImpl;
        this.cdcServiceImpl = cdcServiceImpl;
        this.siteRepo = siteRepo;
        this.cdcRepo = cdcRepo;
        this.marqueRepo = marqueRepo;
        this.vehiculeServiceImpl = vehiculeServiceImpl;
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

        return devServiceImpl.getDevByCdcId(id);}

    @GetMapping("dev/dll-id")
    public List<Dev> getDevByDll(@RequestParam String dll){
        return devRepo.findByDll(dll);
    }
    @GetMapping("/devs/by-marque/{marqueId}")
    public List<Dev> getDevsByMarque(@PathVariable int marqueId) {
        Marque marque = marqueRepo.getById(marqueId);
        List<Vehicule> vehicules = vehiculeServiceImpl.getVehiculesByMarque(marque);
        List<Dev> devs = new ArrayList<>();
        for (Vehicule vehicule : vehicules) {
            devs.addAll(devServiceImpl.getDevsByVehicule(vehicule));
        }
        return devs;
    }

    }