package com.example.adocaoDeAnimais.adocao;

import com.example.adocaoDeAnimais.animal.AnimalModel;
import com.example.adocaoDeAnimais.animal.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdocaoService {
    private final AdocaoRepository adocaoRepository;
   // private final AdotanteRepository adotanteRepository;
    private final AnimalRepository animalRepository;

    public AdocaoService(AdocaoRepository adocaoRepository/*,AdotanteRepository adotanteRepository*/ , AnimalRepository animalRepository) {
        this.adocaoRepository = adocaoRepository;
       // this.adotanteRepository = adotanteRepository;
        this.animalRepository = animalRepository;
    }

    //precisa de adotante para realizar a adocao;
    public String solicitarAdocao(AdocaoDTO adocaoDTO) {
        //Optional<AdotanteModel> adotanteModelOptional = adotanteRepository.findById(adocaoDTO.idAdotante());
        Optional<AnimalModel> animalOptional = animalRepository.findById(adocaoDTO.animalId().getId());

        return "ERROR: Adotante ou animal não encontrados.";
    }

    public void analisarAdocao(){}

    public void listarAdocoes(){}

}
