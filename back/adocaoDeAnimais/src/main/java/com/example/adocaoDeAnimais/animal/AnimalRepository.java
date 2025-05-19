package com.example.adocaoDeAnimais.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<AnimalModel, UUID> {
}
