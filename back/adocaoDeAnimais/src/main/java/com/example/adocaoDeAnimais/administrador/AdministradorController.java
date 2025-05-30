package com.example.adocaoDeAnimais.administrador;

import com.example.adocaoDeAnimais.adotante.*;
import com.example.adocaoDeAnimais.animal.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrador")
@CrossOrigin(origins = "http://localhost:5173")
public class AdministradorController {
    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping("/adotantes")
    public ResponseEntity<List<AdotanteResponseDTO>> listarAdotantes() {
        List<AdotanteResponseDTO> adotantes = administradorService.listarAdotantes();
        return ResponseEntity.ok(adotantes);
    }

    @DeleteMapping("/adotantes/{id}")
    public ResponseEntity<Void> deletarAdotante(@PathVariable Long id) {
        administradorService.deletarAdotante(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/animais/cadastro")
    public ResponseEntity<AnimalResponseDTO> cadastrarAnimal(@RequestBody AnimalRequestDTO animalDto) {
        AnimalResponseDTO animalResponseDTO = administradorService.cadastraAnimal(animalDto);
        return new ResponseEntity<>(animalResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/animais")
    public ResponseEntity<List<AnimalResponseDTO>> listarAnimais() {
        List<AnimalResponseDTO> animais = administradorService.listarAnimais();
        return ResponseEntity.ok(animais);
    }

    @DeleteMapping("/animais/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        administradorService.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }


}
