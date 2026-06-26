package br.com.alan.GerenciadorDeTarefas.entity;

import br.com.alan.GerenciadorDeTarefas.enums.StatusTarefa;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
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




}
