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

    @GetMapping("/listar")
    public ResponseEntity<List<AnimalResponseDTO>> listarAnimais() {
        List<AnimalResponseDTO> animais = animalService.listarAnimais();
        return ResponseEntity.ok(animais);
    }

    //criar a busca
}
