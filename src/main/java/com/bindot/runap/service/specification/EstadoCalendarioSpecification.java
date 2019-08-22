/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.EstadoCalendario;
import com.bindot.runap.model.EstadoCalendario_;

/**
 * @author Cesar Zamorano
 *
 */
public class EstadoCalendarioSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<EstadoCalendario> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(EstadoCalendario_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<EstadoCalendario> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(EstadoCalendario_.enabled), enabled);
	}

}
