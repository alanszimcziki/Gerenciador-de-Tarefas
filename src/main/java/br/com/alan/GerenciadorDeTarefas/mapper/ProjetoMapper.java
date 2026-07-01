package br.com.alan.GerenciadorDeTarefas.mapper;


import br.com.alan.GerenciadorDeTarefas.dtos.ProjetoDTO;
import br.com.alan.GerenciadorDeTarefas.entity.Projeto;

public class ProjetoMapper {

    public static Projeto toProjeto(ProjetoDTO projetoDTO) {
        return Projeto.builder()
                .id(projetoDTO.getId())
                .nomeProjeto(projetoDTO.getNomeProjeto())
                .descricao(projetoDTO.getDescricao())
                .usuario(UsuarioMapper.toUsuario(projetoDTO.getUsuario()))
                .build();
    }

    public static ProjetoDTO toProjetoDTO(Projeto projeto) {
        return ProjetoDTO.builder()
                .id(projeto.getId())
                .nomeProjeto(projeto.getNomeProjeto())
                .descricao(projeto.getDescricao())
                .usuario(UsuarioMapper.toUsuarioDTO(projeto.getUsuario()))
                .build();
    }
}
