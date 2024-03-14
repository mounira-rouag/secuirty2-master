package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(IdVeh.class)
@Table(name="`Vehid`")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CODE_VEH`")
    private int codeVeh;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`NOMVEH`")
    private String nomVeh;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`NOMINTERNE`")
    private String nominterne;



    @Column(name = "`TESTGLOBAL`")
    private boolean testGlobal;
    @Column(name = "`MSG_DIAG`")
    private String msgDiag;
    @Column(name = "`GRPMARQ`")
    private String grpMarque;
    @Column(name = "`FROM`")
    private String from;
    @Column(name = "`TO`")
    private String to;
    @Column(name = "`OnlyElec`")

    private boolean onlyElec;
    @Column(name = "`AVERTISS_ELEC`")
    private boolean avertissElec;

    @ManyToOne // ManyToOne relationship with Marque
    @JoinColumn(name = "`IdMarque`") // Foreign key column mapping
    private Marque marque;


}
