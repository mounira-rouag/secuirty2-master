package com.example.Project.Services;

import com.example.Project.Models.*;
import com.example.Project.Repositories.DevRepository;
import com.example.Project.Repositories.UserInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevServiceImpl {
    private final DevRepository devRepo;
    private final UserInterface userRepo;

    public DevServiceImpl(DevRepository devRepo, UserInterface userRepo) {
        this.devRepo = devRepo;
        this.userRepo = userRepo;
    }
    public List<Dev> getAllDev() {
        return devRepo.findAll();
    }


    public Optional<Dev> findById(int id) {
        return devRepo.findById(id);
    }

    public List<Dev> getDevByCdcId(int id ){
        return devRepo.findByCDC(id);
    }
public List<Dev> getDevsByVehicule(Vehicule vehicule){
        return devRepo.getDevByvehicules(vehicule);

}
    public List<Dev> getDevsByUserId(int userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getDevs();
        } else {
            // Handle case when user with given ID is not found
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
}
