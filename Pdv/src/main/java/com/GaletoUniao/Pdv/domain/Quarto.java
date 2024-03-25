package com.GaletoUniao.Pdv.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "tipo_quarto")
    private String tipoQuarto;

    @Column(name = "valor_pernoite")
    private double valorPernoite;

    private boolean disponivel;
}
