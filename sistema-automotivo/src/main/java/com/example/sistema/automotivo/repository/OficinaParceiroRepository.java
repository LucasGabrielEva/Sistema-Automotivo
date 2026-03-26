package com.example.sistema.automotivo.repository;

import com.example.sistema.automotivo.model.OficinaParceiraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OficinaParceiroRepository extends JpaRepository<OficinaParceiraModel, Long> {

    // Calcula a distância em KM usando a fórmula de Haversine
    @Query(value = "SELECT * FROM oficinas_parceiras " +
            "WHERE (6371 * acos(cos(radians(:latitudeCliente)) * cos(radians(latitude)) * " +
            "cos(radians(longitude) - radians(:longitudeCliente)) + " +
            "sin(radians(:latitudeCliente)) * sin(radians(latitude)))) <= :raioKm",
            nativeQuery = true)
    List<OficinaParceiraModel> buscarOficinasProximas(
            @Param("latitudeCliente") Double latitudeCliente,
            @Param("longitudeCliente") Double longitudeCliente,
            @Param("raioKm") Double raioKm);

}
