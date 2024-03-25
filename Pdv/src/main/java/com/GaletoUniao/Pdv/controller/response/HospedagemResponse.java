package com.GaletoUniao.Pdv.controller.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospedagemResponse {

    private int Id;
    private LocalDateTime dataEntrada;
    private Long quartoId;
    private String clienteId;
    private String funcionarioId;
    private boolean finalizada;
}
