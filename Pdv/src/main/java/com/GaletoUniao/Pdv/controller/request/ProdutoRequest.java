package com.GaletoUniao.Pdv.controller.request;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoRequest {

    @NonNull
    private String nome;
    @NonNull
    private BigDecimal valorUnitario;
}
