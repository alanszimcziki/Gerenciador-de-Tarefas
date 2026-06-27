package br.com.alan.GerenciadorDeTarefas.mapper;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarUsuarioRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.UsuarioResponse;
import br.com.alan.GerenciadorDeTarefas.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toUsuario(CadastrarUsuarioRequest request){
        return Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .senha(request.senha())
                .build();
    }

    public static UsuarioResponse toUsuarioResponse(Usuario usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();
    }


}
