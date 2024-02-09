package br.com.arturbarth.rinhabackend.service;

import br.com.arturbarth.rinhabackend.dto.*;
import br.com.arturbarth.rinhabackend.entity.Cliente;
import br.com.arturbarth.rinhabackend.entity.Transacao;
import br.com.arturbarth.rinhabackend.repository.ClienteRepository;
import br.com.arturbarth.rinhabackend.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    public ClienteService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public Cliente getCliente(int id) {
        return clienteRepository.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TransacaoResponse createTransacao(int id, TransacaoRequest transacaoRequest) {
        var cliente = this.getCliente(id);
        long novoSaldo = getNovoSaldo(transacaoRequest, cliente);
        var transacao = new Transacao(cliente, transacaoRequest.valor(), transacaoRequest.tipo(), transacaoRequest.descricao(), LocalDateTime.now());
        transacaoRepository.save(transacao);
        cliente.setSaldo(novoSaldo);
        clienteRepository.save(cliente);
        return new TransacaoResponse(cliente.getLimite(), cliente.getSaldo());
    }

    private static long getNovoSaldo(TransacaoRequest transacaoRequest, Cliente cliente) {
        long novoSaldo;
        if (transacaoRequest.tipo().equals(TipoTransacaoEnum.d)) {
            novoSaldo = cliente.getSaldo() - transacaoRequest.valor();
            if (novoSaldo < -cliente.getLimite()) {
                throw new BusinessException(HttpStatus.UNPROCESSABLE_ENTITY, "Limite excedido");
            }
        } else {
            novoSaldo = cliente.getSaldo() + transacaoRequest.valor();
        }
        return novoSaldo;
    }

    public ExtratoResponse getExtrato(int id) {
        var cliente = getCliente(id);
        List<Transacao> transacoes = transacaoRepository.findTransacaoByClienteId(id);
        var saldo = new SaldoResponse(
                cliente.getSaldo(),
                LocalDateTime.now(),
                cliente.getLimite());
        var transacaoResponse = transacoes.stream().map(it -> new TransacaoExtratoResponse(it.getValor(), it.getTipo(), it.getDescricao(), it.getData() ) ).toList();
        return new ExtratoResponse(saldo, transacaoResponse);

    }


}
