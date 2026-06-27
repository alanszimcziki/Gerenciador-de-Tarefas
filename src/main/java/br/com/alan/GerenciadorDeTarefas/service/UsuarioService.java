package br.com.alan.GerenciadorDeTarefas.service;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarUsuarioRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.UsuarioResponse;
import br.com.alan.GerenciadorDeTarefas.entity.Usuario;
import br.com.alan.GerenciadorDeTarefas.mapper.UsuarioMapper;
import br.com.alan.GerenciadorDeTarefas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponse cadastrarUsuario(CadastrarUsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());

        return UsuarioMapper.toUsuarioResponse(usuarioRepository.save(usuario));

    }


}
