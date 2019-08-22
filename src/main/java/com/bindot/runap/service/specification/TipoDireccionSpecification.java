package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.TipoDireccion;
import com.bindot.runap.model.TipoDireccion_;

/**
 * @author Cesar Zamorano
 *
 */
public class TipoDireccionSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<TipoDireccion> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(TipoDireccion_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<TipoDireccion> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(TipoDireccion_.enabled), enabled);
	}

	/**
	 * 
	 */
	private TipoDireccionSpecification() {
	}
}
