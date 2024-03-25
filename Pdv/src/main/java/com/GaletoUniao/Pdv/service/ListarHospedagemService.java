package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.response.HospedagemResponse;
import com.GaletoUniao.Pdv.mapper.HospedagemMapper;
import com.GaletoUniao.Pdv.respository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarHospedagemService {

    @Autowired
    private HospedagemRepository hospedagemRepository;

    public Page<HospedagemResponse> listar(Pageable pageable) {
        return hospedagemRepository.findAll(pageable)
                .map(HospedagemMapper::toResponse);
    }

    public Page<HospedagemResponse> listarAtivas(Pageable pageable) {
        return hospedagemRepository.findAllByFinalizada(false, pageable)
                .map(HospedagemMapper::toResponse);
    }
}
