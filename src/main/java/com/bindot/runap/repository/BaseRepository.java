/**
 * 
 */
package com.bindot.runap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Cesar Zamorano
 *
 */
@Repository
public interface BaseRepository<E> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
}
