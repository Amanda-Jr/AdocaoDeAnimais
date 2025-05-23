package com.example.adocaoDeAnimais.doacao;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Service
public class DoacaoService {
    private final DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    public String realizarDoacao(DoacaoDTO doacaoDto) {
        if (doacaoDto.valor() <= 0.0) {
            return "ERROR: Valor inserido inválido.";
        } else if (Period.between(doacaoDto.dataNasc(), LocalDate.now()).getYears() < 18) {
            return "ERROR: Apenas maiores de 18 anos podem realizar doações.";
        } else {
            DoacaoModel doacao = new DoacaoModel();
            doacao.setNomeDoador(doacaoDto.nome());
            doacao.setDataNasc(doacaoDto.dataNasc());
            doacao.setValor(doacaoDto.valor());
            doacao.setDataDoacao(LocalDateTime.now());

            this.doacaoRepository.save(doacao);
            return "Doação de R$" + doacaoDto.valor() + " realizada com sucesso por " + doacaoDto.nome() + ".";
        }
    }


    public List<DoacaoModel> listarDoacoes() {
        return this.doacaoRepository.findAll();
    }
}
