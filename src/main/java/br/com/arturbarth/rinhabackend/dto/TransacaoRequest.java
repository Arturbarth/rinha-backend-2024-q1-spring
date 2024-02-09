package br.com.arturbarth.rinhabackend.dto;


import jakarta.validation.constraints.*;

public record TransacaoRequest(@NotNull @Positive(message = "Valor deve ser positivo") long valor,
                               @NotNull TipoTransacaoEnum tipo,
                               @NotNull(message = "Descrição obrigatória!") @Size(min = 1, max = 10) String descricao) {
}
