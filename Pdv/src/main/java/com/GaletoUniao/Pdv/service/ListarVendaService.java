package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.response.VendaResponse;
import com.GaletoUniao.Pdv.mapper.VendaMapper;
import com.GaletoUniao.Pdv.respository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarVendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Page<VendaResponse> listar(Pageable pageable) {
        return vendaRepository.findAll(pageable)
                .map(VendaMapper::toResponse);
    }
}
