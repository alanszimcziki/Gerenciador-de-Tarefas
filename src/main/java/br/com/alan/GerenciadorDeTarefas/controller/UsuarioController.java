package br.com.alan.GerenciadorDeTarefas.controller;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarUsuarioRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.UsuarioResponse;
import br.com.alan.GerenciadorDeTarefas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody CadastrarUsuarioRequest request) {
        UsuarioResponse response = usuarioService.cadastrarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
