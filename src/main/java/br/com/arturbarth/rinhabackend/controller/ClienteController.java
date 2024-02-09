package br.com.arturbarth.rinhabackend.controller;


import br.com.arturbarth.rinhabackend.dto.ExtratoResponse;
import br.com.arturbarth.rinhabackend.dto.TransacaoRequest;
import br.com.arturbarth.rinhabackend.dto.TransacaoResponse;
import br.com.arturbarth.rinhabackend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clientes", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtratoResponse> extrato(@PathVariable int id) {
        return ResponseEntity.ok(clienteService.getExtrato(id));
    }

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<TransacaoResponse> transacoes(@PathVariable int id, @Valid @RequestBody TransacaoRequest transacaoRequest) {
        return ResponseEntity.ok(clienteService.createTransacao(id, transacaoRequest));
    }



}
