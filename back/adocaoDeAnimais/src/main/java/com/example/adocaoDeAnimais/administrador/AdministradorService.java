package com.example.adocaoDeAnimais.administrador;

import com.example.adocaoDeAnimais.adocao.*;
import com.example.adocaoDeAnimais.adotante.*;
import com.example.adocaoDeAnimais.animal.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    private final AdotanteService adotanteService;
    private final AnimalService animalService;
    private final AdocaoService adocaoService;

    public AdministradorService(AdotanteService adotanteService, AnimalService animalService, AdocaoService adocaoService) {
        this.adotanteService = adotanteService;
        this.animalService = animalService;
        this.adocaoService = adocaoService;
    }

    public List<AdotanteResponseDTO> listarAdotantes() {
        return adotanteService.listarAdotantes();
    }

    public void deletarAdotante(Long id) {
        adotanteService.deletarAdotante(id);
    }

    public AnimalResponseDTO cadastraAnimal(AnimalRequestDTO animalDto) {
        return animalService.cadastraAnimal(animalDto);
    }

    public List<AnimalFiltroDTO> listarAnimais() {
        return animalService.listarAnimais();
    }

    public void deletarAnimal(Long id) {
        animalService.deletarAnimal(id);
    }
}
