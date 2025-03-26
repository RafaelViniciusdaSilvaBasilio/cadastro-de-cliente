package br.com.spring.projeto1.repository;

import br.com.spring.projeto1.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findByClienteId(Long clienteId);
}
