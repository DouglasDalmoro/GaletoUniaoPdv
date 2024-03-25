package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.response.HospedagemResponse;
import com.GaletoUniao.Pdv.domain.Hospedagem;
import com.GaletoUniao.Pdv.domain.Quarto;
import com.GaletoUniao.Pdv.mapper.HospedagemMapper;
import com.GaletoUniao.Pdv.respository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class DetalharHospedagemService {

    @Autowired
    private HospedagemRepository hospedagemRepository;

    public HospedagemResponse detalhar(Long id) {

        Hospedagem hospedagem = hospedagemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Ocorreu um erro inesperado"));

        return HospedagemMapper.toResponse(hospedagem);
    }
}
