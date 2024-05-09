package com.nour.projetspringboot.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String nom;
    @Column(length = 20)
    private String prenom;
    @Column(length = 150)
    private String adr;
    @Column(length = 60)
    private String email;
    @Column(length = 8)
    private String tel;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "inscription",
            joinColumns = @JoinColumn(
                    name = "id_etudiant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "id_formation", referencedColumnName = "id"))

    private Collection<Formation> formations;

}
