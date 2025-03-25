package br.com.fiap.tds2ps.spring_mvc.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf" )
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep")
    private String cep;

    @Column(name = "genero")
    private String genero;

    @Column(name = "historico_atendimento", columnDefinition = "CLOB")
    private String historicoAtendimento;

}