package br.com.alan.GerenciadorDeTarefas.controller;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarUsuarioRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.LoginRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.TokenResponse;
import br.com.alan.GerenciadorDeTarefas.dtos.UsuarioResponse;
import br.com.alan.GerenciadorDeTarefas.entity.Usuario;
import br.com.alan.GerenciadorDeTarefas.mapper.TokenMapper;
import br.com.alan.GerenciadorDeTarefas.service.JWTService;
import br.com.alan.GerenciadorDeTarefas.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JWTService  jwtService;

    public UsuarioController(UsuarioService usuarioService,
                             AuthenticationManager authenticationManager,
                             JWTService jwtService) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@Valid @RequestBody CadastrarUsuarioRequest request) {
        UsuarioResponse response = usuarioService.cadastrarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> loginUsuario(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken usuarioESenha = new UsernamePasswordAuthenticationToken(request.email(),request.senha());
        Authentication auth = authenticationManager.authenticate(usuarioESenha);

        String token = jwtService.gerarToken(auth);
        TokenResponse response = TokenMapper.tokenToTokenResponse(token);
        return ResponseEntity.ok(response);

    }
}
