package com.example.Project.Repositories;

import com.example.Project.Models.Marque;
import com.example.Project.Models.Sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitesRepository extends JpaRepository<Sites, Integer> {

}
