package br.com.alan.GerenciadorDeTarefas.dtos;

import lombok.Builder;

@Builder
public record UsuarioResponse(Long id, String nome, String email) {
}
