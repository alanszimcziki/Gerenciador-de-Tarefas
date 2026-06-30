package br.com.alan.GerenciadorDeTarefas.mapper;

import br.com.alan.GerenciadorDeTarefas.dtos.TarefaDTO;
import br.com.alan.GerenciadorDeTarefas.entity.Tarefa;

public class TarefaMapper {

    public static Tarefa toTarefa(TarefaDTO request) {
        return Tarefa.builder()
                .nomeTarefa(request.getNomeTarefa())
                .statusTarefa(request.getStatusTarefa())
                .dataTarefa(request.getDataTarefa())
                .build();
    }

    public static TarefaDTO toTarefaResponse(Tarefa request) {
        return TarefaDTO.builder()
                .id(request.getId())
                .nomeTarefa(request.getNomeTarefa())
                .statusTarefa(request.getStatusTarefa())
                .dataTarefa(request.getDataTarefa())
                .build();
    }
}
