package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.domain.Hospedagem;
import com.GaletoUniao.Pdv.domain.Quarto;
import com.GaletoUniao.Pdv.respository.HospedagemRepository;
import com.GaletoUniao.Pdv.respository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ExcluirHospedagemService {

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Transactional
    public void excluir(Long id) {

        Hospedagem hospedagem = hospedagemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Ocorreu um erro inesperado"));

        Quarto quarto = quartoRepository.findById(hospedagem.getQuartoId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Quarto não cadastrado ou não disponivel"));

        quarto.setDisponivel(true);

        hospedagemRepository.delete(hospedagem);
        quartoRepository.save(quarto);
    }
}
