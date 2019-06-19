/**
 * 
 */
package com.bindot.runap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.bindot.runap.model.Corredor;

/**
 * @author Cesar Zamorano
 *
 */
public interface CorredorRepository extends JpaRepository<Corredor, Long>, JpaSpecificationExecutor<Corredor> {
}
