package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.request.ProdutoRequest;
import com.GaletoUniao.Pdv.domain.Produto;
import com.GaletoUniao.Pdv.mapper.ProdutoMapper;
import com.GaletoUniao.Pdv.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.GaletoUniao.Pdv.mapper.ProdutoMapper.toEntity;

@Service
public class CadastrarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public void cadastrar(ProdutoRequest produtoRequest) {

        Produto produto = toEntity(produtoRequest);
        produtoRepository.save(produto);
    }
}
