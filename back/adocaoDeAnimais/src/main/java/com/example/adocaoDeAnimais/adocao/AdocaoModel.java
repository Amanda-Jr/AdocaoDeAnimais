package com.example.adocaoDeAnimais.adocao;

import com.example.adocaoDeAnimais.animal.AnimalModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_adocoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adocao")
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "id_adotante")
    //private AdotanteModel adotanteId;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private AnimalModel animalId;

    @Column(nullable = false, updatable = false)
    private LocalDate dataAdocao;

    private StatusAdocao status;

}
