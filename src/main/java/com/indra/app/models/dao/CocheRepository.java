package com.indra.app.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.app.models.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
    // Se pueden agregar métodos personalizados si es necesario
}


/*
 * "Data Access Object" DAO
 * Clase de persistencia que se encarga de acceder a los datos
 * 
 * La anotación Repository marca la clase como componente de persistencia
 * de acceso a datos
 */