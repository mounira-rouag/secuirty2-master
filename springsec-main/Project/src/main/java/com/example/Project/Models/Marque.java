package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="`Marque`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CODMAR`")
    private int idMarque;
    @Column(name = "`NOMMAR`")
    private String nomMarque;



}
