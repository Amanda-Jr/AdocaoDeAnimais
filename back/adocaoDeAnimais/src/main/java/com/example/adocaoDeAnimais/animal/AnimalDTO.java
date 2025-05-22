package com.example.adocaoDeAnimais.animal;

import java.time.LocalDate;
import java.util.List;

public record AnimalDTO (Long id,
                         String nome,
                         String raca,
                         LocalDate dataNasc,
                         boolean castracao,
                         String resumo,
                         boolean visivel,
                         String imagemUrl,
                         List<VacinasModel> vacinas) {
}
