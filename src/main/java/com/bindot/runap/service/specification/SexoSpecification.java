/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Sexo;
import com.bindot.runap.model.Sexo_;

/**
 * @author Cesar Zamorano
 *
 */
public class SexoSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Sexo> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Sexo_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Sexo> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Sexo_.enabled), enabled);
	}

	/**
	 * 
	 */
	private SexoSpecification() {
	}
}
