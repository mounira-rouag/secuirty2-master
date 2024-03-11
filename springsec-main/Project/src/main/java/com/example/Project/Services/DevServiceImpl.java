package com.example.Project.Services;

import com.example.Project.Models.Dev;
import com.example.Project.Models.Marque;
import com.example.Project.Repositories.DevRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DevServiceImpl {
    private final DevRepository devRepo;

    public DevServiceImpl(DevRepository devRepo) {
        this.devRepo = devRepo;
    }
    public List<Dev> getAllDev() {
        return devRepo.findAll();
    }



}
