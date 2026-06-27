package br.com.alan.GerenciadorDeTarefas.dtos;

import lombok.Builder;

@Builder
public record CadastrarUsuarioRequest(String nome, String email, String senha) {
}
