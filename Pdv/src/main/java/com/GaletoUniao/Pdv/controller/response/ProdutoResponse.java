package com.GaletoUniao.Pdv.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    private Long id;
    private String nome;
    private BigDecimal valorUnitario;
}
