package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="`SITES`")
public class Sites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdSite`")
    private int IdSite;
    @Column(name = "`NomSite`")
    private String NomSite;
}
