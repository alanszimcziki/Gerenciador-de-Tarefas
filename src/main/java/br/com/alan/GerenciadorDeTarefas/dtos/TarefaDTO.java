package br.com.alan.GerenciadorDeTarefas.dtos;

import br.com.alan.GerenciadorDeTarefas.enums.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TarefaDTO {
    private Long id;
    private String nomeTarefa;
    private StatusTarefa statusTarefa;
    private LocalDate dataTarefa;
    private ProjetoDTO projeto;
}
