package com.nour.projetspringboot.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    @NotNull
    private String Titre;
    @NotNull
    @Column(length = 150)
    private String Description;
    @NotNull
    private float prix;
    @NotNull
    private int nbrHeures;
    @ManyToOne
    private Enseignant enseignant;



}
