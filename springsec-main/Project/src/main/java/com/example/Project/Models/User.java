package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`UTILISATEUR`",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "`Pseudo`"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
@Column(name = "`IdUtilisateur`")
    private int id;
    @Column(name = "`Nom`")
    private String firstname;
    @Column(name = "`Prenom`")
    private String lastname;
    @Column(name = "`Pseudo`")
    private String username;

    private String email;
@Column(name = "`IdSite`")
    private int site;
    @Column(name = "`Profil`")
private String Profile;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password, String lastname , String firstname, int site) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.site=site;
    }

}
