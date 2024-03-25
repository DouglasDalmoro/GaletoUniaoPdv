package com.GaletoUniao.Pdv.controller.request;

import com.GaletoUniao.Pdv.domain.Usuario;
import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class HospedagemRequest {

    @NonNull
    private Long quartoId;
    @NonNull
    private String clienteName;
    @NonNull
    private Long funcionarioId;
}
