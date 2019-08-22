/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.TipoCarrera;
import com.bindot.runap.model.TipoCarrera_;

/**
 * @author Cesar Zamorano
 *
 */
public class TipoCarreraSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<TipoCarrera> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(TipoCarrera_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<TipoCarrera> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(TipoCarrera_.enabled), enabled);
	}

	/**
	 * 
	 */
	private TipoCarreraSpecification() {
	}
}
