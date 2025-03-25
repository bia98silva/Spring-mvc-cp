package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.entities.Patient;
import br.com.fiap.tds2ps.spring_mvc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private static PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);

    }
    public static List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findByCpf(String cpf) {
        return patientRepository.findByCpf(cpf);
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }


}