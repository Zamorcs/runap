/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Formato;
import com.bindot.runap.model.Formato_;

/**
 * @author Cesar Zamorano
 *
 */
public class FormatoSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Formato> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Formato_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Formato> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Formato_.enabled), enabled);
	}

	/**
	 * 
	 */
	private FormatoSpecification() {
	}
}
