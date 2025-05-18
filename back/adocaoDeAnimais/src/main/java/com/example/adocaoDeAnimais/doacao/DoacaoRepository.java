package com.example.adocaoDeAnimais.doacao;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoacaoRepository extends JpaRepository<DoacaoModel, UUID> {
}