package com.nour.projetspringboot.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    @NotNull
    private String prenom;
    @NotNull
    @Column(length = 20)
    private String nom;
    @Column(length = 60)
    @NotNull
    private String email;
    @NotNull
    @Column(length = 8)
    private String tel;
    @JsonIgnore
    @OneToMany(mappedBy = "enseignant", fetch =FetchType.EAGER)
    private List<Formation> formations=new ArrayList<>();


}
