package com.GaletoUniao.Pdv.mapper;

import com.GaletoUniao.Pdv.controller.request.CadastrarUsuarioRequest;
import com.GaletoUniao.Pdv.controller.response.UsuarioResponse;
import com.GaletoUniao.Pdv.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(CadastrarUsuarioRequest request) {

        return Usuario.builder()
                .cpf(request.getCpf())
                .email(request.getEmail())
                .nome(request.getNome())
                .telefone(request.getTelefone())
                .tipoUsuario(request.getTipoUsuario())
                .build();
    }

    public static UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse
                .builder()
                .cpf(usuario.getCpf())
                .id(usuario.getId())
                .nome(usuario.getNome())
                .tipoUsuario(usuario.getTipoUsuario())
                .telefone(usuario.getTelefone())
                .build();
    }
}
