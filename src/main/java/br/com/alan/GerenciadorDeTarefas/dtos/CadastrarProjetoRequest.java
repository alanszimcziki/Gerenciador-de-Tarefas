package br.com.alan.GerenciadorDeTarefas.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CadastrarProjetoRequest(

        @NotBlank(message = "nome do projeto não pode estar vazio!")
        String nomeProjeto,

        @NotBlank(message = "descrição do projeto não pode estar vazio!")
        String descricao,

        @NotNull(message = "usuário do projeto deve ser informado!")
        UsuarioDTO usuarioDTO) {
}
