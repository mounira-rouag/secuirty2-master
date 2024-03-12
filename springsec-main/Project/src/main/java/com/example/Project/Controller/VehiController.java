package com.example.Project.Controller;

import com.example.Project.Models.Vehicule;
import com.example.Project.Repositories.VehiculeRepository;
import com.example.Project.Services.VehiculeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/vehi")
public class VehiController {

   private final VehiculeRepository vehiculeRepo;
    private final VehiculeServiceImpl vehiculeServieImpl;

    public VehiController(VehiculeRepository vehiculeRepo, VehiculeServiceImpl vehiculeServieImpl) {
        this.vehiculeRepo = vehiculeRepo;
        this.vehiculeServieImpl = vehiculeServieImpl;
    }

    /**find vehicues by marque */
@GetMapping("/all-vehibymarque")
    public List<Vehicule> findVehByMarque(int idmarque){
     return vehiculeServieImpl.getVehByMarques(idmarque);
}



}
