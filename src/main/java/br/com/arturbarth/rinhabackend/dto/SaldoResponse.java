package br.com.arturbarth.rinhabackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record SaldoResponse(long total,
                            @JsonProperty("data_extrato")
                            LocalDateTime data,
                            long limite ) {
}
