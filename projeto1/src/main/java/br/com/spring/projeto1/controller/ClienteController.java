package br.com.spring.projeto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import br.com.spring.projeto1.model.Cliente;
import br.com.spring.projeto1.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes") // Definindo um caminho base
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Endpoint para retornar uma saudação personalizada (exemplo de uso de @PathVariable)
    @GetMapping("/{nome}")
    public ResponseEntity<String> retornaOlaMundo(@PathVariable String nome) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        clienteRepository.save(cliente);
        return ResponseEntity.ok("Teste " + nome);
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para salvar um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        cliente.setId(id);
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // Endpoint para deletar um cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }

    // Endpoint para buscar um cliente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent()
                ? ResponseEntity.ok(cliente.get())  // Se cliente encontrado, retorna status 200 OK com o cliente
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");  // Caso contrário, retorna 404 NOT FOUND
    }


    // Endpoint para buscar clientes pelo nome (usando query parameter)
    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeContainingIgnoreCase(nome.trim());
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarCliente(@RequestParam(required = false) String nome, @RequestParam(required = false) String cpf) {
        if ((nome == null || nome.trim().isEmpty()) && (cpf == null || cpf.trim().isEmpty())) {
            return ResponseEntity.badRequest().body("Informe um Nome ou CPF para pesquisar.");
        }

        if (cpf != null && !cpf.trim().isEmpty()) {
            Optional<Cliente> cliente = clienteRepository.findByCpf(cpf.trim());
            if (cliente.isPresent()) {
                return ResponseEntity.ok(cliente.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
            }
        } else {
            List<Cliente> clientes = clienteRepository.findByNomeContainingIgnoreCase(nome.trim());
            if (clientes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cliente encontrado.");
            }
            return ResponseEntity.ok(clientes);
        }
    }
}

