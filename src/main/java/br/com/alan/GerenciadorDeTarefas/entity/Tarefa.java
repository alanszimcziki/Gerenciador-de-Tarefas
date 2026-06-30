package br.com.alan.GerenciadorDeTarefas.entity;

import br.com.alan.GerenciadorDeTarefas.enums.StatusTarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeTarefa;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTarefa statusTarefa;

    @Column(nullable = false)
    private LocalDate dataTarefa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;



    public void iniciarTarefa(){
        if (this.statusTarefa != StatusTarefa.PENDENTE){
            throw new IllegalArgumentException("Só é possível iniciar uma tarefa que já esteja pendente: " + this.statusTarefa);
        }
        this.statusTarefa = StatusTarefa.ANDAMENTO;
    }

    public void finalizarTarefa(){
        if (this.statusTarefa != StatusTarefa.ANDAMENTO){
            throw new IllegalArgumentException("Só é possível finalizar uma tarefa que já esteja em andamento: " + this.statusTarefa);
        }
        this.statusTarefa = StatusTarefa.CONCLUIDA;
    }






}
