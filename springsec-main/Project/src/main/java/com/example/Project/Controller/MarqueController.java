package com.example.Project.Controller;

import com.example.Project.Models.Marque;
import com.example.Project.Services.MarqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/marques")
public class MarqueController {

    private final MarqueServiceImpl marqueService;

    public MarqueController(MarqueServiceImpl marqueService) {
        this.marqueService = marqueService;
    }
@GetMapping("/all-marques")
    public List<String> getAllMarqueNames() {
        return marqueService.getAllMarques().stream()
                .map(marque -> marque.getNomMarque())
                .collect(Collectors.toList());
    }
}
