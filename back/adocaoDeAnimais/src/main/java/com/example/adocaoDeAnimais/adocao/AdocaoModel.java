package com.example.adocaoDeAnimais.adocao;

import com.example.adocaoDeAnimais.animal.AnimalModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_adocoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adocao")
    private UUID id;

    //@ManyToOne
    //@JoinColumn(name = "id_adotante")
    //private AdotanteModel adotante;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private AnimalModel nomeAnimal;

    @Column(name = "data_adocao")
    private LocalDate dataAdocao;

    @OneToOne
    @JoinColumn(name = "id_status")
    private Status status;

}
