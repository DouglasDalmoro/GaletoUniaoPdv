package com.GaletoUniao.Pdv.controller.request;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarVendaRequest {

    @NonNull
    private String nome;

    private Long funcionarioId;
}
