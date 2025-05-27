package com.example.adocaoDeAnimais.adocao;

import com.example.adocaoDeAnimais.adotante.AdotanteModel;
import com.example.adocaoDeAnimais.adotante.AdotanteRepository;
import com.example.adocaoDeAnimais.animal.AnimalModel;
import com.example.adocaoDeAnimais.animal.AnimalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdocaoService {
    private final AdocaoRepository adocaoRepository;
    private final AdotanteRepository adotanteRepository;
    private final AnimalRepository animalRepository;

    public AdocaoService(AdocaoRepository adocaoRepository,AdotanteRepository adotanteRepository , AnimalRepository animalRepository) {
        this.adocaoRepository = adocaoRepository;
        this.adotanteRepository = adotanteRepository;
        this.animalRepository = animalRepository;
    }


    public String solicitarAdocao(AdocaoDTO adocaoDTO) {
        Optional<AdotanteModel> adotanteOptional = adotanteRepository.findById(adocaoDTO.adotanteId().getIdAdotante());
        Optional<AnimalModel> animalOptional = animalRepository.findById(adocaoDTO.animalId().getIdAnimal());

        if(adotanteOptional.isEmpty() || animalOptional.isEmpty())
            return "ERROR: Adotante ou animal não foram encontrados";

        AdocaoModel adocao = new AdocaoModel();
        adocao.setAdotanteId(adotanteOptional.get());
        adocao.setAnimalId(animalOptional.get());
        adocao.setDataAdocao(LocalDate.now());
        adocao.setStatus(StatusAdocao.EM_ANALISE);

        adocaoRepository.save(adocao);

        return "Sua solicitação de adoção foi realizada com sucesso!";
    }

    public void analisarAdocao(){}

    public List<AdocaoDTO> listarAdocoes(){
        return adocaoRepository.findAll().stream().map(adocao -> new AdocaoDTO(adocao.getId(),
                adocao.getAdotanteId(),
                adocao.getAnimalId(),
                adocao.getDataAdocao(),
                adocao.getStatus()
                )).collect(Collectors.toList());
    }

}
