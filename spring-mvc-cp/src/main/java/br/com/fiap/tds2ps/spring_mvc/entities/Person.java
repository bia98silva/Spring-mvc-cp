package br.com.fiap.tds2ps.spring_mvc.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Person {

    @Id
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    public Person() {
    }

    public Person(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}
