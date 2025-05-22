package com.example.adocaoDeAnimais.animal;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public String cadastraAnimal(AnimalDTO animalDTO) {
        AnimalModel animal = new AnimalModel();
        animalRepository.save(animal);
        return "Animal cadastrado com sucesso!";
    }

    public void procurarAnimal() {}

    public void deletarAnimal() {}

    public void atualizarAnimal() {}

    public void listarAnimais() {}
}
