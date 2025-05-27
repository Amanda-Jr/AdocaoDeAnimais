package com.example.adocaoDeAnimais.adocao;

import com.example.adocaoDeAnimais.adotante.AdotanteModel;
import com.example.adocaoDeAnimais.animal.AnimalModel;

import java.time.LocalDate;

public record AdocaoDTO (Long id,
                        AdotanteModel adotanteId,
                        AnimalModel animalId,
                        LocalDate dataAdocao,
                        StatusAdocao statusAdocao){
}
