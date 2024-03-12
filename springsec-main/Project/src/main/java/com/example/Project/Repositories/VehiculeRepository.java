package com.example.Project.Repositories;

import com.example.Project.Models.IdVeh;
import com.example.Project.Models.User;
import com.example.Project.Models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository  extends JpaRepository<Vehicule, IdVeh> {
    @Query("SELECT v FROM Vehicule v WHERE v.marque.idMarque = ?1")
    List<Vehicule> findVehiculesByMarque(@Param("idMarque")int idMarque);
}
