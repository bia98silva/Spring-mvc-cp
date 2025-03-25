package br.com.fiap.tds2ps.spring_mvc.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "consulta")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_cpf")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "profissional_cpf")
    private Medical medical;

    @Column(name = "data_hora")
    private LocalDateTime dateTime;

    @Column(name = "anamnese")
    private String anamnese;

    @Column(name = "prescrição")
    private String prescription;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ConsultationStatus status;

    public static Consultation createConsultation(Patient patient, Medical medical, LocalDateTime now, ConsultationStatus consultationStatus) {
        Consultation consultation = new Consultation();
        consultation.setPatient(patient);
        consultation.setMedical(medical);
        consultation.setDateTime(now);
        consultation.setStatus(consultationStatus);
        return consultation;
    }

    public enum ConsultationStatus {
        AGENDADA,
        CONCLUIDA,
        CANCELADA
    }
}
