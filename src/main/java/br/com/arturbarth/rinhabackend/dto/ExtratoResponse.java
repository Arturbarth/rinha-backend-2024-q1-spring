package br.com.arturbarth.rinhabackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ExtratoResponse(SaldoResponse saldo,
                              @JsonProperty("ultimas_transacoes")
                              List<TransacaoExtratoResponse> ultimasTransacoes) {


}
