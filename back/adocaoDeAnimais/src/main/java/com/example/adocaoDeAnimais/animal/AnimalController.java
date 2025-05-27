package com.example.adocaoDeAnimais.animal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
@CrossOrigin(origins = "http://localhost:5173")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<AnimalResponseDTO> cadastrarAnimal(@RequestBody AnimalRequestDTO animalDto){
        AnimalResponseDTO animalCadastrado = animalService.cadastraAnimal(animalDto);
        return ResponseEntity.ok(animalCadastrado);
    }

    @GetMapping("/busca")
    public ResponseEntity<List<AnimalResponseDTO>> buscaAnimais(
            @RequestParam(required = false) String animal,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) String location) {

        System.out.println("Parâmetros recebidos: animal=" + animal + ", size=" + size + ", age=" + age + ", location=" + location);

        List<AnimalResponseDTO> animais = animalService.buscarAnimais(animal, size, age, location);
        return ResponseEntity.ok(animais);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AnimalResponseDTO>> listarAnimais() {
        List<AnimalResponseDTO> animais = animalService.listarAnimais();
        return ResponseEntity.ok(animais);
    }
}
