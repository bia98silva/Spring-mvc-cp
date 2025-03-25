package br.com.fiap.tds2ps.spring_mvc.dto;

import br.com.fiap.tds2ps.spring_mvc.entities.Person;

public class ConsultationDto extends Person {

    private String historicoAtendimento;

    public ConsultationDto() {
    }

    public ConsultationDto(String cpf, String nome) {
        super(cpf, nome);
    }

    public String getHistoricoAtendimento() {
        return historicoAtendimento;
    }

    public void setHistoricoAtendimento(String historicoAtendimento) {
        this.historicoAtendimento = historicoAtendimento;
    }
}

