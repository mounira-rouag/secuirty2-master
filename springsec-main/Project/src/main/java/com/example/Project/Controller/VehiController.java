package com.example.Project.Controller;

import com.example.Project.Models.Marque;
import com.example.Project.Models.Vehicule;
import com.example.Project.Repositories.MarqueRepository;
import com.example.Project.Repositories.VehiculeRepository;
import com.example.Project.Services.VehiculeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/vehi")
public class VehiController {

   private final VehiculeRepository vehiculeRepo;
    private final VehiculeServiceImpl vehiculeServieImpl;
private final MarqueRepository marqueRepo;
    public VehiController(VehiculeRepository vehiculeRepo, VehiculeServiceImpl vehiculeServieImpl, MarqueRepository marqueRepo) {
        this.vehiculeRepo = vehiculeRepo;
        this.vehiculeServieImpl = vehiculeServieImpl;
        this.marqueRepo = marqueRepo;
    }

    /**find vehicues by marque */
    @GetMapping("/by-marque/{marqueId}")
    public List<Vehicule> getVehiculesByMarque(@PathVariable int marqueId) {

        Marque marque = marqueRepo.getById(marqueId);
        return vehiculeServieImpl.getVehiculesByMarque(marque);
    }




}
