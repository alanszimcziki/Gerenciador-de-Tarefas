package br.com.alan.GerenciadorDeTarefas.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;

public abstract class ControllerUtils {

    public static String obterLogin(Authentication auth) {
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal() == null) {
            throw new UsernameNotFoundException("Usuário não autenticado!");
        }

        Jwt jwt = (Jwt) auth.getPrincipal();
        return jwt.getSubject();

    }

}
