package com.GaletoUniao.Pdv.respository;

import com.GaletoUniao.Pdv.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senhaIncriptada);

}
