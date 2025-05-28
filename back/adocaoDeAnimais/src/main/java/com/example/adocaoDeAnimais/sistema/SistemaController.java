package com.example.adocaoDeAnimais.sistema;


import com.example.adocaoDeAnimais.adotante.*;
import com.example.adocaoDeAnimais.animal.AnimalResponseDTO;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/api/sistema")
@CrossOrigin(origins = "http://localhost:5173")
public class SistemaController {
    private final SistemaService sistemaService;

    public SistemaController(SistemaService sistemaService) {
        this.sistemaService = sistemaService;
    }

    @PostMapping("/cadastro")
    public AdotanteResponseDTO cadastrarAdotante(@RequestBody AdotanteRequestDTO adotanteRequest) {
        return sistemaService.cadastrarAdotante(adotanteRequest);
    }

    @PostMapping("/login")
    public AdotanteModel loginAdotante(@RequestBody AdotanteRequestDTO adotanteRequest) throws AuthenticationException {
        return sistemaService.loginAdotante(adotanteRequest);
    }

    @GetMapping("/filtro")
    public List<AnimalResponseDTO> buscaAnimal(@RequestParam("animal") String animal,
                                               @RequestParam("size") String size,
                                               @RequestParam("age") String age,
                                               @RequestParam("location") String location) {
        return sistemaService.buscaAnimal(animal, size, age, location);
    }

    @GetMapping("/listar")
    public List<AnimalResponseDTO> listarAnimais() {
        return sistemaService.listarAnimais();
    }
}
