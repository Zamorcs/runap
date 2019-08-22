/**
 * 
 */
package com.bindot.runap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bindot.runap.model.Carrera;

/**
 * @author Cesar Zamorano
 *
 */
@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long>, JpaSpecificationExecutor<Carrera> {
}
