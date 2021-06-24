package io.github.rafael.modelEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//  @NotEmpty(message = "{campo.nome.obrigatorio}")
    @Column(nullable = false, length = 150)
    @NotEmpty(message = "O campo nome é obrigatório.")
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    public Cliente(Integer id,String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
