package br.com.alan.GerenciadorDeTarefas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjetoDTO {

    private Long id;
    private String nomeProjeto;
    private String descricao;
    private UsuarioDTO usuario;
    private List<TarefaDTO> tarefas;



}
