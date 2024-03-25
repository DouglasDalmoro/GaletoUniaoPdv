package com.GaletoUniao.Pdv.controller.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class QuartoResponse {

    private int Id;
    private String tipoQuarto;
    private double valorPernoite;
    private boolean disponivel;
}
