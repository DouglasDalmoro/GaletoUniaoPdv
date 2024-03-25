package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.Seguranca;
import com.GaletoUniao.Pdv.controller.request.CadastrarUsuarioRequest;
import com.GaletoUniao.Pdv.domain.Usuario;
import com.GaletoUniao.Pdv.mapper.UsuarioMapper;
import com.GaletoUniao.Pdv.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastrarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void cadastrar(CadastrarUsuarioRequest request) {

        Usuario usuario = UsuarioMapper.toEntity(request);
        usuario.setSenha(Seguranca.getMD5(request.getSenha()));

        usuarioRepository.save(usuario);
    }
}
