package com.example.adocaoDeAnimais.adotante;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdotanteService {
    private final AdotanteRepository adotanteRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdotanteService(AdotanteRepository adotanteRepository, BCryptPasswordEncoder passwordEncoder) {
        this.adotanteRepository = adotanteRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public AdotanteResponseDTO cadastrarAdotante(@Valid AdotanteRequestDTO dto){
        Optional<AdotanteModel> adotantes = adotanteRepository.findByEmail(dto.email());
        if(adotantes.isPresent())
            throw new ValidationException("Email já cadastrado.");

        String senhaCriptografada = passwordEncoder.encode(dto.senha());

        AdotanteModel adotante = new AdotanteModel();

        adotante.setNome(dto.nome());
        adotante.setEmail(dto.email());
        adotante.setTelefone(dto.telefone());
        adotante.setSenha(senhaCriptografada);

        AdotanteModel salvo = adotanteRepository.save(adotante);

        return this.converterParaDTO(salvo);

    }

    public AdotanteModel loginAdotante(String email, String senha) throws AuthenticationException {
        Optional<AdotanteModel> adotanteOptional = adotanteRepository.findByEmail(email);

        if(adotanteOptional.isEmpty())
            throw new AuthenticationException("Email não encontrado");

        AdotanteModel adotante = adotanteOptional.get();

        if(!passwordEncoder.matches(senha, adotante.getSenha()))
            throw new AuthenticationException("Senha incorreta.");


        return adotante;

    }

    public void atualizarAdotante(){}

    public void removerAdotante(){}

    public AdotanteResponseDTO acessarAdotante(Long id){
        AdotanteModel adotante = adotanteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Adotante não encontrado"));
        return converterParaDTO(adotante);
    }

    public List<AdotanteResponseDTO> listarAdotantes() {
        List<AdotanteModel> adotantes = adotanteRepository.findAll();
        List<AdotanteResponseDTO> resultado = new ArrayList<>();

        for (AdotanteModel adotante : adotantes) {
            resultado.add(converterParaDTO(adotante));
        }
        return resultado;
    }


    private AdotanteResponseDTO converterParaDTO(AdotanteModel adotante) {
        return new AdotanteResponseDTO(
                adotante.getIdAdotante(),
                adotante.getNome(),
                adotante.getEmail(),
                adotante.getTelefone()
        );
    }

}
