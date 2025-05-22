package com.example.adocaoDeAnimais.doacao;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<DoacaoModel, Long> {
}