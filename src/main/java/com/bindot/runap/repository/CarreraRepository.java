/**
 * 
 */
package com.bindot.runap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.bindot.runap.model.Carrera;

/**
 * @author Cesar Zamorano
 *
 */
public interface CarreraRepository extends JpaRepository<Carrera, Long>, JpaSpecificationExecutor<Carrera> {
}
