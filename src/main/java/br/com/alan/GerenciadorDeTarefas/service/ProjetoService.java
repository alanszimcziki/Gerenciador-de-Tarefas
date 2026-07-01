package br.com.alan.GerenciadorDeTarefas.service;

import br.com.alan.GerenciadorDeTarefas.dtos.CadastrarProjetoRequest;
import br.com.alan.GerenciadorDeTarefas.dtos.ProjetoDTO;
import br.com.alan.GerenciadorDeTarefas.entity.Projeto;
import br.com.alan.GerenciadorDeTarefas.entity.Usuario;
import br.com.alan.GerenciadorDeTarefas.mapper.ProjetoMapper;
import br.com.alan.GerenciadorDeTarefas.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final TarefaService tarefaService;

    public ProjetoService(ProjetoRepository projetoRepository, TarefaService tarefaService) {
        this.projetoRepository = projetoRepository;
        this.tarefaService = tarefaService;
    }

    public ProjetoDTO cadastrarProjeto(CadastrarProjetoRequest request, String login) {
        Usuario usuarioLogado = tarefaService.validarLoginUsuario(login, request.usuarioDTO());

        Projeto projeto = new Projeto();
        projeto.setUsuario(usuarioLogado);
        projeto.setNomeProjeto(request.nomeProjeto());
        projeto.setDescricao(request.descricao());
        projetoRepository.save(projeto);

        return ProjetoMapper.toProjetoDTO(projeto);
    }


}
