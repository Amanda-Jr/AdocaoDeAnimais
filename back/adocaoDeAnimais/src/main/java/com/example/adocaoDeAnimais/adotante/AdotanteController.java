package com.example.adocaoDeAnimais.adotante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/api/adotante")
@CrossOrigin(origins = "http://localhost:5173")
public class AdotanteController {

    private final AdotanteService adotanteService;

    public AdotanteController(AdotanteService adotanteService) {
        this.adotanteService = adotanteService;
    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<AdotanteResponseDTO> cadastrarAdotante(@RequestBody AdotanteRequestDTO dto) {
        AdotanteResponseDTO adotanteCadastrado = adotanteService.cadastrarAdotante(dto);
        return ResponseEntity.ok(adotanteCadastrado);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            AdotanteModel adotante = adotanteService.loginAdotante(loginDTO.getEmail(), loginDTO.getSenha());
            return ResponseEntity.ok(adotante);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<AdotanteResponseDTO>> listarAdotantes() {
        List<AdotanteResponseDTO> adotantes = adotanteService.listarAdotantes();
        return ResponseEntity.ok(adotantes);
    }

}

