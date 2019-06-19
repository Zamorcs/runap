/**
 * 
 */
package com.bindot.runap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.bindot.runap.model.Calendario;

/**
 * @author Cesar Zamorano
 *
 */
@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long>, JpaSpecificationExecutor<Calendario> {
}
