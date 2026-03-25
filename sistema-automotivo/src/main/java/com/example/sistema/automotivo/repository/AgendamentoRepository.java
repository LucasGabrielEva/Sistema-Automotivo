package com.example.sistema.automotivo.repository;

import com.example.sistema.automotivo.model.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {
}
