package com.example.adocaoDeAnimais.adocao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adocao")
@CrossOrigin(origins = "http://localhost:5173")
public class AdocaoController {
    private final AdocaoService adocaoService;

    public AdocaoController(AdocaoService adocaoService) {
        this.adocaoService = adocaoService;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<String> solicitarAdocao(@RequestBody AdocaoDTO adocao) {
        String retorno = adocaoService.solicitarAdocao(adocao);
        if(retorno.startsWith("ERROR"))
            return ResponseEntity.badRequest().body(retorno);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AdocaoDTO>> listarAdocoes() {
        List<AdocaoDTO> lista = adocaoService.listarAdocoes();
        return ResponseEntity.ok(lista);
    }
}
