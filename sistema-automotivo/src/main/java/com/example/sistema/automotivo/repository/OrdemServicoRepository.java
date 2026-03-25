package com.example.sistema.automotivo.repository;

import com.example.sistema.automotivo.model.OrdemServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServicoModel, Long> {
}
