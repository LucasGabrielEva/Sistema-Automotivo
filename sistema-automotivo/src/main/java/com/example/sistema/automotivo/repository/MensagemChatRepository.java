package com.example.sistema.automotivo.repository;

import com.example.sistema.automotivo.model.MensagemChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensagemChatRepository extends JpaRepository<MensagemChatModel, Long> {
    // Busca o histórico do chat ordenado por data e hora de envio
    List<MensagemChatModel> findByOrdemServicoIdOrderByDataEnvioAsc(Long ordemServicoId);
}
