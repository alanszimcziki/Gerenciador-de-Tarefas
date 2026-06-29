package br.com.alan.GerenciadorDeTarefas.mapper;

import br.com.alan.GerenciadorDeTarefas.dtos.TokenResponse;

public class TokenMapper {
    public static TokenResponse tokenToTokenResponse(String token) {
        return TokenResponse.builder()
                .token(token)
                .build();
    }

}
