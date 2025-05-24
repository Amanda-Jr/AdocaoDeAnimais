package com.example.adocaoDeAnimais.adotante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdotanteRepository extends JpaRepository<AdotanteModel, Long> {
    Optional<AdotanteModel> findByEmail(String dto);
}
