package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.domain.Quarto;
import com.GaletoUniao.Pdv.domain.Vendas;
import com.GaletoUniao.Pdv.respository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ExcluirVendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public void excluir(Long id) {

        Vendas venda = vendaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Venda não encontrada"));

        vendaRepository.delete(venda);
    }
}
