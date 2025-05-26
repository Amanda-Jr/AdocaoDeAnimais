package com.example.adocaoDeAnimais.animal;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public AnimalResponseDTO cadastraAnimal(AnimalRequestDTO animalDto) {
        AnimalModel animal = new AnimalModel();
        animal.setNome(animalDto.nome());
        animal.setRaca(animalDto.raca());
        animal.setDataNasc(animalDto.dataNasc());
        animal.setCastracao(animalDto.castracao());
        animal.setResumo(animalDto.resumo());
        animal.setVisivel(animalDto.visivel());
        animal.setImagemUrl(animalDto.imagemUrl());

        String[] listar = animalDto.vacinas().split(",");
        List<String> vacinas = Arrays.asList(listar);
        animal.setVacinas(vacinas);

        AnimalModel saveAnimal = animalRepository.save(animal);

        return converterParaResponse(saveAnimal);
    }

    public AnimalResponseDTO buscarAnimal(Long id) throws Exception {
        Optional<AnimalModel> optionalAnimal = animalRepository.findById(id);
        if(optionalAnimal.isEmpty()) {
            throw new Exception("Animal não encontrado!");
        }
        return converterParaResponse(optionalAnimal.get());
    }

    public void deletarAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public void atualizarAnimal() {}

    public List<AnimalResponseDTO> listarAnimais() {
        return animalRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public AnimalResponseDTO converterParaResponse(AnimalModel animal) {
        return new AnimalResponseDTO(
                animal.getIdAnimal(),
                animal.getNome(),
                animal.getRaca(),
                animal.getDataNasc(),
                animal.isCastracao(),
                animal.getResumo(),
                animal.isVisivel(),
                animal.getImagemUrl(),
                animal.getVacinas()
        );
    }

}
