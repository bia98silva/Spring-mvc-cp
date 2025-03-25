package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.dto.ConsultationDto;
import br.com.fiap.tds2ps.spring_mvc.dto.MedicalDto;
import br.com.fiap.tds2ps.spring_mvc.entities.Consultation;
import br.com.fiap.tds2ps.spring_mvc.entities.Medical;
import br.com.fiap.tds2ps.spring_mvc.entities.Patient;
import br.com.fiap.tds2ps.spring_mvc.repositories.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final PatientService patientService;
    private final MedicalService medicalService;

    public ConsultationService(ConsultationRepository consultationRepository, PatientService patientService, MedicalService medicalService) {
        this.consultationRepository = consultationRepository;
        this.patientService = patientService;
        this.medicalService = medicalService;
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public Optional<Consultation> findById(Long id) {
        return consultationRepository.findById(id);
    }

    public Consultation save(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteById(Long id) {
        consultationRepository.deleteById(id);
    }

    public List<Consultation> findByPatientCpf(String patientCpf) {
        return consultationRepository.findByPatient_CpfOrderByDateTimeDesc(patientCpf);
    }

    public Consultation scheduleConsultation(String patientCpf, String medicalCpf) {
        Optional<Patient> patientOpt = patientService.findByCpf(patientCpf);
        Optional<Medical> medicalOpt = medicalService.findByCpf(medicalCpf);

        if (patientOpt.isPresent() && medicalOpt.isPresent()) {
            Consultation consultation = Consultation.createConsultation(
                    patientOpt.get(),
                    medicalOpt.get(),
                    LocalDateTime.now(),
                    Consultation.ConsultationStatus.AGENDADA
            );
            return consultationRepository.save(consultation);
        }
        throw new IllegalArgumentException("Paciente ou Médico não encontrado");
    }

    public ConsultationDto toDto(Consultation consultation) {
        Patient patient = consultation.getPatient();
        ConsultationDto dto = new ConsultationDto(patient.getCpf(), patient.getNome());
        dto.setHistoricoAtendimento(patient.getHistoricoAtendimento());
        return dto;
    }

    public Consultation startConsultation(String cpf, String medicalCpf, String anamnese, String prescription) {
        Optional<Patient> patientOpt = patientService.findByCpf(cpf);
        Optional<Medical> medicalOpt = medicalService.findByCpf(medicalCpf);

        if (patientOpt.isPresent() && medicalOpt.isPresent()) {
            Consultation consultation = Consultation.createConsultation(
                    patientOpt.get(),
                    medicalOpt.get(),
                    LocalDateTime.now(),
                    Consultation.ConsultationStatus.valueOf("AGENDADA")
            );
            consultation.setAnamnese(anamnese);  // Setando a anamnese
            consultation.setPrescription(prescription);  // Setando a prescrição

            return consultationRepository.save(consultation);
        }
        throw new IllegalArgumentException("Paciente ou Médico não encontrado");
    }

    public Consultation finishConsultation(Long consultationId, MedicalDto medicalDto) {
        Optional<Consultation> consultationOpt = consultationRepository.findById(consultationId);

        if (consultationOpt.isPresent()) {
            Consultation consultation = consultationOpt.get();

            consultation.setStatus(Consultation.ConsultationStatus.CONCLUIDA);

            Medical medical = medicalService.findByCpf(medicalDto.getCpf())
                    .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
            consultation.setMedical(medical);

            return consultationRepository.save(consultation);
        } else {
            throw new RuntimeException("Consulta não encontrada");
        }
    }
}
