package br.com.fiap.tds2ps.spring_mvc.repositories;

import br.com.fiap.tds2ps.spring_mvc.entities.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface MedicalRepository extends JpaRepository<Medical, Long> {
    Optional<Medical> findByCpf(String cpf);
}