package br.com.alan.GerenciadorDeTarefas.controller;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarTarefaRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.TarefaDTO;
import br.com.alan.GerenciadorDeTarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;


    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> cadastrarTarefa(@RequestBody CadastrarTarefaRequest request,
                                                     Authentication auth
    ) {
        String login = ControllerUtils.obterLogin(auth);
        TarefaDTO dto = tarefaService.cadastrarTarefa(request, login);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> listarTarefaPorID(@PathVariable Long id,
                                                       Authentication auth) {

        String login = ControllerUtils.obterLogin(auth);
        TarefaDTO dto = tarefaService.listarTarefaPorID(login, id);
        return ResponseEntity.ok(dto);
    }
    @PatchMapping("/inicia/{id}")
    public ResponseEntity<TarefaDTO> iniciarTarefa(@PathVariable Long id,
            Authentication auth) {

        String login = ControllerUtils.obterLogin(auth);
        TarefaDTO dto = tarefaService.iniciarTarefa(id, login);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/finalizar/{id}")
    public ResponseEntity<TarefaDTO> finalizarTarefa(@PathVariable Long id,
                                                     Authentication auth) {

        String login = ControllerUtils.obterLogin(auth);
        TarefaDTO dto = tarefaService.finalizarTarefa(id,login);
        return ResponseEntity.ok(dto);

    }

}
