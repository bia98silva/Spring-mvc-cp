package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.entities.Medical;
import br.com.fiap.tds2ps.spring_mvc.repositories.MedicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalService {

    private final MedicalRepository medicalRepository;

    public MedicalService(MedicalRepository medicalRepository) {
        this.medicalRepository = medicalRepository;
    }

    public List<Medical> findAll() {
        return medicalRepository.findAll();
    }

    public Optional<Medical> findByCpf(String cpf) {
        return medicalRepository.findByCpf(cpf);
    }
}
