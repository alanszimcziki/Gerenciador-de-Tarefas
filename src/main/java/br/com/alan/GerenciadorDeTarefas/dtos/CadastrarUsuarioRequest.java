package br.com.alan.GerenciadorDeTarefas.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CadastrarUsuarioRequest(
        @NotBlank(message = "O campo do nome é obrigatório")
        String nome,

        @NotBlank(message = "O campo do E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "O campo da senha é obrigatória")
        String senha) {
}
