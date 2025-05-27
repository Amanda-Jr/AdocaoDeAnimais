package com.example.adocaoDeAnimais.adocao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends JpaRepository<AdocaoModel, Long> {
}
