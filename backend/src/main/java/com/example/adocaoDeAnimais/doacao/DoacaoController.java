package com.example.adocaoDeAnimais.doacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {
    private final DoacaoService doacaoService;


    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    @GetMapping
    public ResponseEntity<List<DoacaoModel>> listarDoacoes() {
        return ResponseEntity.ok(doacaoService.listarDoacoes());
    }
}
