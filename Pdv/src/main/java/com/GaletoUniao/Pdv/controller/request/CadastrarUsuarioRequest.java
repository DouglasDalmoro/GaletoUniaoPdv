package com.GaletoUniao.Pdv.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CadastrarUsuarioRequest {


    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String senha;
    private String tipoUsuario;
}
