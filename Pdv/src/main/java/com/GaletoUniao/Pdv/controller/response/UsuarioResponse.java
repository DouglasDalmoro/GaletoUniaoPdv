package com.GaletoUniao.Pdv.controller.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponse {

    private int id;
    private String nome;
    private String telefone;
    private String cpf;
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
}
