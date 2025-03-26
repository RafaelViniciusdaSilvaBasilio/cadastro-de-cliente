package br.com.spring.projeto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.spring.projeto1.model.Contato;
import br.com.spring.projeto1.repository.ContatoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    // Cadastro de um novo contato
    @PostMapping
    public ResponseEntity<Contato> salvarContato(@RequestBody Contato contato) {
        Contato novoContato = contatoRepository.save(contato);
        return new ResponseEntity<>(novoContato, HttpStatus.CREATED);
    }

    // Listar todos os contatos de um cliente específico
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Contato>> listarContatos(@PathVariable Long clienteId) {
        List<Contato> contatos = contatoRepository.findByClienteId(clienteId);
        return ResponseEntity.ok(contatos);
    }

    // Editar um contato
    @PutMapping("/{id}")
    public ResponseEntity<Contato> editarContato(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Contato> contatoExistente = contatoRepository.findById(id);
        if (contatoExistente.isPresent()) {
            contato.setId(id);
            Contato contatoAtualizado = contatoRepository.save(contato);
            return ResponseEntity.ok(contatoAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Excluir um contato
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirContato(@PathVariable Long id) {
        if (contatoRepository.existsById(id)) {
            contatoRepository.deleteById(id);
            return ResponseEntity.ok("Contato excluído com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
    }
}
