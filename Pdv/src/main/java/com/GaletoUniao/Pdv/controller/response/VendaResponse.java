package com.GaletoUniao.Pdv.controller.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaResponse {

    private int Id;

    private LocalDateTime data;

    private String clienteId;

    private String funcionarioId;

    private boolean finalizada;
}
