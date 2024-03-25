package com.GaletoUniao.Pdv.mapper;


import com.GaletoUniao.Pdv.controller.request.HospedagemRequest;
import com.GaletoUniao.Pdv.controller.response.HospedagemResponse;
import com.GaletoUniao.Pdv.domain.Hospedagem;

public class HospedagemMapper {
    public static Hospedagem toEntity(HospedagemRequest request) {
        return Hospedagem
                .builder()
                .clienteId(request.getClienteName())
                .build();
    }

    public static HospedagemResponse toResponse(Hospedagem hospedagem) {
        return HospedagemResponse
                .builder()
                .Id(hospedagem.getId())
                .clienteId(hospedagem.getClienteId())
                .dataEntrada(hospedagem.getDataEntrada())
                .funcionarioId(hospedagem.getFuncionarioId())
                .quartoId(hospedagem.getQuartoId())
                .finalizada(hospedagem.isFinalizada())
                .build();
    }
}
