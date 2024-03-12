package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
@Entity
@Table(name = "`CDC`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CDC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="`IdCDC`")
    private int idCdc;

    @Column(name = "`NomCDC`", length = 100)
    private String nomCdc;

    @Column(name = "`RefCDC`", length = 50)
    private String refCdc;

    @Column(name = "`IndCDC`", length = 50)
    private String indCdc;

    @Column(name = "`IdReverse`")
    private Long idReverse;

    @Column(name = "`IdSite`")
    private Long idSite;

    @Column(name = "`Création`")
    private Timestamp creation;

    @Column(name = "`SignatureOk`", nullable = false)
    private boolean signatureOk;

    @Column(name = "`RefCDCArdia`", length = 10)
    private String refCdcArdia;
}
