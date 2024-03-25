package com.GaletoUniao.Pdv.service;

import com.GaletoUniao.Pdv.Seguranca;
import com.GaletoUniao.Pdv.controller.request.LoginReques;
import com.GaletoUniao.Pdv.controller.response.UsuarioResponse;
import com.GaletoUniao.Pdv.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.GaletoUniao.Pdv.mapper.UsuarioMapper.toResponse;

@Service
public class LoginService {

    @Autowired
    private Seguranca seguranca;

    public UsuarioResponse login(LoginReques reques) {
        Usuario usuario = seguranca.validarUsuarioSeguro(reques.getEmail(), reques.getSenha());
        UsuarioResponse usuarioResponse = toResponse(usuario);

        return usuarioResponse;
    }
}
