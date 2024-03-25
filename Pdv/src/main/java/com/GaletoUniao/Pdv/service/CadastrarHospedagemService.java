package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.request.HospedagemRequest;
import com.GaletoUniao.Pdv.domain.Hospedagem;
import com.GaletoUniao.Pdv.domain.Quarto;
import com.GaletoUniao.Pdv.domain.Usuario;
import com.GaletoUniao.Pdv.mapper.HospedagemMapper;
import com.GaletoUniao.Pdv.respository.HospedagemRepository;
import com.GaletoUniao.Pdv.respository.QuartoRepository;
import com.GaletoUniao.Pdv.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import static com.GaletoUniao.Pdv.mapper.HospedagemMapper.toEntity;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CadastrarHospedagemService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public void cadastrar(HospedagemRequest request) {

        boolean temFuncionario = usuarioRepository.existsById(request.getFuncionarioId());
        boolean temQuarto = quartoRepository.existsById(request.getQuartoId());

        if(temFuncionario && temQuarto) {
            Quarto quarto = quartoRepository.findByIdAndDisponivel(request.getQuartoId(), true)
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Quarto não cadastrado ou não disponivel"));
            Usuario funcionario = usuarioRepository.findById(request.getFuncionarioId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Funcionario não encontrado"));


            quarto.setDisponivel(false);
            quartoRepository.save(quarto);

            Hospedagem hospedagem = toEntity(request);
            hospedagem.setQuartoId(request.getQuartoId());
            hospedagem.setFuncionarioId(funcionario.getNome());
            hospedagem.setFinalizada(false);
            hospedagem.setDataEntrada(now());
            hospedagemRepository.save(hospedagem);
        } else
            throw new ResponseStatusException(NOT_FOUND, "Não encontramos o funcionario ou o quarto não está cadastrado");
    }
}
