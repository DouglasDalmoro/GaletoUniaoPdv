package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.controller.request.CadastrarVendaRequest;
import com.GaletoUniao.Pdv.domain.Quarto;
import com.GaletoUniao.Pdv.domain.Usuario;
import com.GaletoUniao.Pdv.domain.Vendas;
import com.GaletoUniao.Pdv.mapper.VendaMapper;
import com.GaletoUniao.Pdv.respository.UsuarioRepository;
import com.GaletoUniao.Pdv.respository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import static com.GaletoUniao.Pdv.mapper.VendaMapper.toEntity;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CadastrarVendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void cadastrar(CadastrarVendaRequest cadastrarVendaRequest) {

        Vendas venda = toEntity(cadastrarVendaRequest);

        Usuario funcionario = usuarioRepository.findById(cadastrarVendaRequest.getFuncionarioId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não cadastrado"));

        venda.setFinalizada(false);
        venda.setFuncionarioId(funcionario.getNome());
        venda.setData(now());

        vendaRepository.save(venda);
    }
}
