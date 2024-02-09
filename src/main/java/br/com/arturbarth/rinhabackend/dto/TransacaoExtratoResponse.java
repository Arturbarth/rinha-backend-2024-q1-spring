package br.com.arturbarth.rinhabackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record TransacaoExtratoResponse(long valor,
                                       TipoTransacaoEnum tipo,
                                       String descricao,
                                       @JsonProperty("realizada_em")
                                       @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
                                       LocalDateTime data) {
}
