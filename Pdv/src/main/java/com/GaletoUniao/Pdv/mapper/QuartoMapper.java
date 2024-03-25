package com.GaletoUniao.Pdv.mapper;

import com.GaletoUniao.Pdv.controller.request.QuartoRequest;
import com.GaletoUniao.Pdv.controller.response.QuartoResponse;
import com.GaletoUniao.Pdv.domain.Quarto;

public class QuartoMapper {
    public static Quarto toEntity(QuartoRequest request) {
        return Quarto
                .builder()
                .tipoQuarto(request.getTipoQuarto())
                .valorPernoite(request.getValorPernoite())
                .build();
    }

    public static QuartoResponse toResponse(Quarto quarto) {
        return QuartoResponse
                .builder()
                .Id(quarto.getId())
                .disponivel(quarto.isDisponivel())
                .tipoQuarto(quarto.getTipoQuarto())
                .valorPernoite(quarto.getValorPernoite())
                .build();
    }
}
