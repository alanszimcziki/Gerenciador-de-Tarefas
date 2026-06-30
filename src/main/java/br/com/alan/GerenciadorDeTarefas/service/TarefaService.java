package br.com.alan.GerenciadorDeTarefas.service;


import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarTarefaRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.TarefaDTO;
import br.com.alan.GerenciadorDeTarefas.dtos.UsuarioDTO;
import br.com.alan.GerenciadorDeTarefas.entity.Tarefa;
import br.com.alan.GerenciadorDeTarefas.entity.Usuario;
import br.com.alan.GerenciadorDeTarefas.enums.StatusTarefa;
import br.com.alan.GerenciadorDeTarefas.mapper.TarefaMapper;
import br.com.alan.GerenciadorDeTarefas.mapper.UsuarioMapper;
import br.com.alan.GerenciadorDeTarefas.repository.TarefaRepository;
import br.com.alan.GerenciadorDeTarefas.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository,
                         UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario validarLoginUsuario(String login, UsuarioDTO usuarioDTO) {
        Usuario usuarioLogado = usuarioRepository.findUsuarioByEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        if (!usuarioLogado.getId().equals(usuarioDTO.getId())) {
            throw new UsernameNotFoundException("O e-mail informando não é desse usuario!");
        }
        return usuarioLogado;


    }

    public TarefaDTO cadastrarTarefa(CadastrarTarefaRequest request, String login) {
        Usuario usuario = validarLoginUsuario(login, request.usuarioDTO());
        Tarefa tarefa = new Tarefa();
        tarefa.setUsuario(usuario);
        tarefa.setNomeTarefa(request.nomeTarefa());
        tarefa.setStatusTarefa(StatusTarefa.PENDENTE);
        tarefa.setDataTarefa(LocalDate.now());
        tarefaRepository.save(tarefa);

        return TarefaMapper.toTarefaResponse(tarefa);

    }

    public TarefaDTO listarTarefaPorID(String login, Long id) {
        Optional<Tarefa> optTarefa = tarefaRepository.findById(id);

        if (optTarefa.isEmpty()) {
            throw new UsernameNotFoundException("Tarefa não encontrada!");
        }
        Tarefa tarefa = optTarefa.get();
        validarLoginUsuario(login, UsuarioMapper.toUsuarioDTO(tarefa.getUsuario()));

        return TarefaMapper.toTarefaResponse(tarefa);
    }

    public TarefaDTO iniciarTarefa(Long id, String login){
        Optional<Tarefa> optTarefa = tarefaRepository.findById(id);

        if (optTarefa.isEmpty()){
            throw new IllegalArgumentException("Tarefa não encontrada!");
        }
        Tarefa tarefa = optTarefa.get();
        validarLoginUsuario(login, UsuarioMapper.toUsuarioDTO(tarefa.getUsuario()));
        tarefa.iniciarTarefa();
        tarefaRepository.save(tarefa);
        return TarefaMapper.toTarefaResponse(tarefa);
    }

    public TarefaDTO finalizarTarefa(Long id, String login){
        Optional<Tarefa> optTarefa = tarefaRepository.findById(id);

        if (optTarefa.isEmpty()){
            throw new IllegalArgumentException("Tarefa não encontrada!");
        }
        Tarefa tarefa = optTarefa.get();
        validarLoginUsuario(login, UsuarioMapper.toUsuarioDTO(tarefa.getUsuario()));
        tarefa.finalizarTarefa();
        tarefaRepository.save(tarefa);
        return TarefaMapper.toTarefaResponse(tarefa);

    }


}
