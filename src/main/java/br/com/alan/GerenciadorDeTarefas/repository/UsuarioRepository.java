package br.com.alan.GerenciadorDeTarefas.repository;

import br.com.alan.GerenciadorDeTarefas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
