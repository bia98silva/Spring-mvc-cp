package br.com.fiap.tds2ps.spring_mvc.repositories;

import br.com.fiap.tds2ps.spring_mvc.entities.Consultation;
import br.com.fiap.tds2ps.spring_mvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByPatientOrderByDateTimeDesc(Patient patient);
    List<Consultation> findByPatient_CpfOrderByDateTimeDesc(String patientCpf);
    List<Consultation> findByStatus(String agendada);
    long count();
    @Query("SELECT COUNT(DISTINCT c.patient) FROM Consultation c")
    long countDistinctPatients();

}
