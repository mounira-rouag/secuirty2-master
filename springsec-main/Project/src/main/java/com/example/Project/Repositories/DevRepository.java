package com.example.Project.Repositories;

import com.example.Project.Models.Dev;
import com.example.Project.Models.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevRepository extends JpaRepository<Dev, Integer> {
    public List<Dev> findbydllname (String s);




}
