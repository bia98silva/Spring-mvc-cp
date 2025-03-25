package br.com.fiap.tds2ps.spring_mvc.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Medical  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "registro_profissional")
    private String registroProfissional;
    }
