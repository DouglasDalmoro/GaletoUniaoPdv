package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.domain.Vendas;
import com.GaletoUniao.Pdv.respository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class FinalizarVenda {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public void finalizar(Long id) {

        Vendas venda = vendaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Venda Não encontrada"));

        venda.setFinalizada(true);
        vendaRepository.save(venda);
    }
}
