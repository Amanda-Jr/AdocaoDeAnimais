package com.example.adocaoDeAnimais.adocao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdocaoRepository extends JpaRepository<AdocaoModel, UUID> {
}
