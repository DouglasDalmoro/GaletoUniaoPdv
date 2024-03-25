package com.GaletoUniao.Pdv.mapper;


import com.GaletoUniao.Pdv.controller.request.ProdutoRequest;
import com.GaletoUniao.Pdv.controller.response.ProdutoResponse;
import com.GaletoUniao.Pdv.domain.Produto;
import com.GaletoUniao.Pdv.respository.ProdutoRepository;

public class ProdutoMapper {
    public static Produto toEntity(ProdutoRequest produtoRequest) {
        return Produto
                .builder()
                .nome(produtoRequest.getNome())
                .valorUnitario(produtoRequest.getValorUnitario())
                .build();
    }

    public static ProdutoResponse toResponse(Produto produto) {
        return ProdutoResponse
                .builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .valorUnitario(produto.getValorUnitario())
                .build();
    }
}
