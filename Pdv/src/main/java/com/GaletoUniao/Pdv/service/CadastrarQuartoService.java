package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.request.QuartoRequest;
import com.GaletoUniao.Pdv.domain.Quarto;
import com.GaletoUniao.Pdv.mapper.QuartoMapper;
import com.GaletoUniao.Pdv.respository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.GaletoUniao.Pdv.mapper.QuartoMapper.toEntity;

@Service
public class CadastrarQuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Transactional
    public void cadastrar(QuartoRequest request) {
        Quarto quarto = toEntity(request);
        quarto.setDisponivel(true);

        quartoRepository.save(quarto);
    }
}
