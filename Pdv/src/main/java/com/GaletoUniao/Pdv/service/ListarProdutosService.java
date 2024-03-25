package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.response.ProdutoResponse;
import com.GaletoUniao.Pdv.domain.Produto;
import com.GaletoUniao.Pdv.mapper.ProdutoMapper;
import com.GaletoUniao.Pdv.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<ProdutoResponse> listar(Pageable pageable) {
        return produtoRepository.findAll(pageable)
                .map(ProdutoMapper::toResponse);
    }
}
