package br.com.alan.GerenciadorDeTarefas.controller;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarProjetoRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.ProjetoDTO;
import br.com.alan.GerenciadorDeTarefas.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> cadastrarProjeto(@RequestBody @Valid CadastrarProjetoRequest request,
                                                       Authentication auth) {
        String login = ControllerUtils.obterLogin(auth);
        ProjetoDTO dto = projetoService.cadastrarProjeto(request, login);
        return ResponseEntity.ok(dto);

    }


}
