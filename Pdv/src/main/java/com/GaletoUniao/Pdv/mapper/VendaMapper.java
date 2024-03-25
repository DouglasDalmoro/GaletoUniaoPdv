package com.GaletoUniao.Pdv.mapper;

import com.GaletoUniao.Pdv.controller.request.CadastrarVendaRequest;
import com.GaletoUniao.Pdv.controller.response.VendaResponse;
import com.GaletoUniao.Pdv.domain.Vendas;

public class VendaMapper {
    public static Vendas toEntity(CadastrarVendaRequest cadastrarVendaRequest) {
        return Vendas
                .builder()
                .clienteId(cadastrarVendaRequest.getNome())
                .build();
    }

    public static VendaResponse toResponse(Vendas vendas) {
        return VendaResponse
                .builder()
                .Id(vendas.getId())
                .clienteId(vendas.getClienteId())
                .data(vendas.getData())
                .finalizada(vendas.isFinalizada())
                .funcionarioId(vendas.getFuncionarioId())
                .build();
    }
}
