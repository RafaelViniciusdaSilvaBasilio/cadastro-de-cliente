package br.com.spring.projeto1.model;

import java.io.Serializable;
import java.time.LocalDate;



import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "clientes")
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1, initialValue = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido. Use o formato XXX.XXX.XXX-XX")
    @Column(unique = true, nullable = false)
    private String cpf;

    @PastOrPresent(message = "Data de nascimento não pode ser no futuro")
    private LocalDate dataNascimento;

    @Size(max = 255, message = "Endereço deve ter no máximo 255 caracteres")
    private String endereco;
}
