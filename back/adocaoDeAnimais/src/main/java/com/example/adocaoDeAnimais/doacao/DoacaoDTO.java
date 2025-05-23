package com.example.adocaoDeAnimais.doacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record DoacaoDTO(
        @NotBlank String nome,
        @NotNull LocalDate dataNasc,
        @Positive double valor
) {}
