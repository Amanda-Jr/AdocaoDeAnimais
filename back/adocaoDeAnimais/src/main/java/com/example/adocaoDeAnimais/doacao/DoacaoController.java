package com.example.adocaoDeAnimais.doacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {
    private final DoacaoService doacaoService;

    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    @PostMapping("/doar")
    public ResponseEntity<String> realizarDoacao(@RequestBody DoacaoDTO doacaoDto) {
        String resultado = doacaoService.realizarDoacao(doacaoDto);

        if (resultado.startsWith("ERROR")) {
            return ResponseEntity.badRequest().body(resultado);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping
    public ResponseEntity<List<DoacaoModel>> listarDoacoes() {
        List<DoacaoModel> doacoes = doacaoService.listarDoacoes();
        return ResponseEntity.ok(doacoes);
    }
}
