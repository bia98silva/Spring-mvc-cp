package br.com.fiap.tds2ps.spring_mvc.repositories;

import br.com.fiap.tds2ps.spring_mvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByCpf(String cpf);
}