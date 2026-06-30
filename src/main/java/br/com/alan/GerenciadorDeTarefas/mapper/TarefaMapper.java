package br.com.alan.GerenciadorDeTarefas.mapper;

import br.com.alan.GerenciadorDeTarefas.dtos.TarefaDTO;
import br.com.alan.GerenciadorDeTarefas.entity.Tarefa;

import java.util.List;

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

    public static List<TarefaDTO>  toTarefaResponse(List<Tarefa> request) {
        return request.stream()
                .map(tarefa -> TarefaMapper.toTarefaResponse(tarefa))
                .toList();
    }
}
