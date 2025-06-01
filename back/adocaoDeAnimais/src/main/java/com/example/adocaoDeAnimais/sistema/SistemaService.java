package com.example.adocaoDeAnimais.sistema;

import com.example.adocaoDeAnimais.adocao.*;
import com.example.adocaoDeAnimais.adotante.*;
import com.example.adocaoDeAnimais.animal.*;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;

@Service
public class SistemaService {
    private final AdotanteService adotanteService;
    private final AnimalService animalService;
    private final AdocaoService adocaoService;

    public SistemaService(AdotanteService adotanteService, AnimalService animalService, AdocaoService adocaoService) {
        this.adotanteService = adotanteService;
        this.animalService = animalService;
        this.adocaoService = adocaoService;
    }

    public AdotanteResponseDTO cadastrarAdotante(AdotanteRequestDTO adotante) {
        return adotanteService.cadastrarAdotante(adotante);
    }

    public AdotanteModel loginAdotante(AdotanteRequestDTO adotante) throws AuthenticationException {
        return adotanteService.loginAdotante(adotante.email(), adotante.senha());
    }

    public List<AnimalFiltroDTO> buscaAnimal(String animal, String size, String age, String location) {
        return animalService.buscarAnimais(animal, size, age, location);
    }

    public List<AnimalFiltroDTO> listarAnimais() {
        return animalService.listarAnimais();
    }

    public AnimalResponseDTO buscaAnimalPorId(Long id) {
        return animalService.buscaAnimalPorId(id);
    }
}
