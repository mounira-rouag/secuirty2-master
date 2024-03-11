package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="`ECU`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ecu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEcu;
    private  String nomEcu;
    private String  typeInj;
    private String phraseTypeInj;

}
