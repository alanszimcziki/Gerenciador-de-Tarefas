package br.com.alan.GerenciadorDeTarefas.service;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarUsuarioRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.UsuarioResponse;
import br.com.alan.GerenciadorDeTarefas.entity.Usuario;
import br.com.alan.GerenciadorDeTarefas.mapper.UsuarioMapper;
import br.com.alan.GerenciadorDeTarefas.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse cadastrarUsuario(CadastrarUsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(passwordEncoder.encode(request.senha()));

        return UsuarioMapper.toUsuarioResponse(usuarioRepository.save(usuario));

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário ou senha não encontrado!"));


        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .authorities(List.of())
                .build();
    }
}
