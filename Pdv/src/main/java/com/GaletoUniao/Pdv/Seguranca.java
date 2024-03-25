package com.GaletoUniao.Pdv;


import com.GaletoUniao.Pdv.domain.Usuario;
import com.GaletoUniao.Pdv.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class Seguranca {

    @Autowired
    private UsuarioRepository repository;


    public static String getMD5(String texto) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(texto.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public Usuario validarUsuarioSeguro(String email, String senha) {
        String senhaIncriptada = getMD5(senha);

        Usuario usuarioEncontrado = repository.findByEmailAndSenha(email, senhaIncriptada);

        return usuarioEncontrado;
    }
}