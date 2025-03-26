package br.com.spring.projeto1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;  // Relaciona com o Cliente

    private String tipoContato;  // Tipo de contato (exemplo: "Telefone", "Email", etc.)
    private String valorContato; // Valor do contato (exemplo: número de telefone ou email)
    private String observacao;   // Observações sobre o contato
}

