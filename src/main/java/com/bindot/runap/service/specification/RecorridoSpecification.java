/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Recorrido;
import com.bindot.runap.model.Recorrido_;

/**
 * @author Cesar Zamorano
 *
 */
public class RecorridoSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Recorrido> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Recorrido_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Recorrido> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Recorrido_.enabled), enabled);
	}

	/**
	 * 
	 */
	private RecorridoSpecification() {
	}
}
