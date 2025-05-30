package com.example.adocaoDeAnimais.animal;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public AnimalResponseDTO cadastraAnimal(AnimalRequestDTO animalDto) {
        AnimalModel animal = new AnimalModel();
        animal.setAnimal(animalDto.animal());
        animal.setSize(animalDto.size());
        animal.setAge(animalDto.age());
        animal.setLocation(animalDto.location());
        animal.setNome(animalDto.name());
        animal.setImagemUrl(animalDto.image());
        animal.setDataNascimento(animalDto.dataNascimento());
        animal.setVacinado(animalDto.vacinado());
        animal.setCastrado(animalDto.castrado());
        animal.setResumo(animalDto.resumo());

        AnimalModel saveAnimal = animalRepository.save(animal);

        return converterParaResponse(saveAnimal);
    }

    public List<AnimalFiltroDTO> buscarAnimais(String animal, String size, String age, String location) {
        Specification<AnimalModel> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (animal != null && !animal.isBlank() && !animal.equalsIgnoreCase("all")) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("animal")),
                        animal.toLowerCase().trim()
                ));
            }
            if (size != null && !size.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("size")),
                        size.toLowerCase().trim()
                ));
            }
            if (age != null && !age.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("age")),
                        age.toLowerCase().trim()
                ));
            }
            if (location != null && !location.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("location")),
                        location.toLowerCase().trim()
                ));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<AnimalModel> animais = animalRepository.findAll(spec);

        return animais.stream()
                .map(this::converterParaFiltroDto)
                .collect(Collectors.toList());
    }


    public List<AnimalFiltroDTO> listarAnimais() {
        List<AnimalModel> animais = animalRepository.findAll();
        return animais.stream()
                .map(this::converterParaFiltroDto)
                .collect(Collectors.toList());
    }

    public AnimalResponseDTO buscaAnimalPorId(Long id) {
        AnimalModel animal = animalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Animal não encontrado!"));
        return converterParaResponse(animal);
    }

    public void deletarAnimal(Long id) {
        if(animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Adotante não econtrado! ");
        }
    }

    public AnimalFiltroDTO converterParaFiltroDto(AnimalModel animal) {
        return new AnimalFiltroDTO(
                animal.getIdAnimal(),
                animal.getAnimal(),
                animal.getNome(),
                animal.getAge(),
                animal.getSize(),
                animal.getLocation(),
                animal.getImagemUrl()
        );
    }

    public AnimalResponseDTO converterParaResponse(AnimalModel animal) {
        return new AnimalResponseDTO(
                animal.getIdAnimal(),
                animal.getAnimal(),
                animal.getSize(),
                animal.getAge(),
                animal.getLocation(),
                animal.getNome(),
                animal.getImagemUrl(),
                animal.getDataNascimento(),
                animal.getVacinado(),
                animal.getCastrado(),
                animal.getResumo()
        );
    }

}
