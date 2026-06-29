package br.com.alan.GerenciadorDeTarefas.dtos;

import lombok.Builder;

@Builder
public record TokenResponse(String token) {
}
