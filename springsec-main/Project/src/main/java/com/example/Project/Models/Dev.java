package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`DEV`")
public class Dev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdDev`")
    private int id;
    @Column(name = "`NomDev`")
    private String devname;
    @Column(name = "`NomDLL`")
    private String dll;
    @Column(name = "`DevDuplique`")
    private boolean devDuplique;
    @Column(name = "`DevComment`")
    private String devComment;
    @Column(name = "`numBug`")
    private String numBug;


@ManyToOne
@JoinColumn(name="id-cdc")
    private CDC cdc;

}
