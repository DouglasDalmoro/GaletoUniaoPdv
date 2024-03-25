package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.response.QuartoResponse;
import com.GaletoUniao.Pdv.mapper.QuartoMapper;
import com.GaletoUniao.Pdv.respository.QuartoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarQuartosService {

    @Autowired
    private QuartoRepository quartoRepository;

    public Page<QuartoResponse> listar(Pageable pageable) {

        return quartoRepository.findAll(pageable)
                .map(QuartoMapper::toResponse);
    }
}
