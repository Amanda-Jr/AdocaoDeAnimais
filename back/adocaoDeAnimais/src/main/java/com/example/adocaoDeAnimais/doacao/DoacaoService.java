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

    public String realizarDoacao(String nome, LocalDate dataNasc, double valor) {
        if (valor <= 0.0) {
            return "ERROR:Valor inserido inválido. ";
        } else if (Period.between(dataNasc, LocalDate.now()).getYears() < 18) {
            return "ERROR: Apenas maiores de 18 anos podem realizar doações.";
        } else {
            DoacaoModel doacao = new DoacaoModel();
            doacao.setNomeDoador(nome);
            doacao.setDataNasc(dataNasc);
            doacao.setValor(valor);
            doacao.setDataDoacao(LocalDateTime.now());
            this.doacaoRepository.save(doacao);
            return "Doação de R$" + valor + " realizada com sucesso por " + nome + ".";
        }
    }

    public List<DoacaoModel> listarDoacoes() {
        return this.doacaoRepository.findAll();
    }
}
