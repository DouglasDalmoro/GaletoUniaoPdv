package com.GaletoUniao.Pdv.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ItemVenda {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private double quantidade;
        private BigDecimal subtotal;
        private String nome;

        @Column(name = "venda_id")
        private int vendaId;
}
