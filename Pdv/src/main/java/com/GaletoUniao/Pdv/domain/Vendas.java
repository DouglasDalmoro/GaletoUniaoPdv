package com.GaletoUniao.Pdv.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private LocalDateTime data;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "cliente_id")
    private String clienteId;

    @Column(name = "funcionario_id")
    private String funcionarioId;

    private boolean finalizada;
}
