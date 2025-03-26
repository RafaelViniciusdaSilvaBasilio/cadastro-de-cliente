package br.com.spring.projeto1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.projeto1.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Busca clientes pelo nome (ignora maiúsculas/minúsculas)
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    // Busca um cliente pelo CPF (garante unicidade)
    Optional<Cliente> findByCpf(String cpf);
}
