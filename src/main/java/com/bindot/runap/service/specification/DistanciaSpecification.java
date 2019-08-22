package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Distancia;
import com.bindot.runap.model.Distancia_;

/**
 * @author Cesar Zamorano
 *
 */
public class DistanciaSpecification {

	/**
	 * @param calle
	 * @return
	 */
	public static Specification<Distancia> likeToDescripcion(String calle) {
		return (root, query, builder) -> builder.like(root.get(Distancia_.descripcion), "%" + calle + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Distancia> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Distancia_.enabled), enabled);
	}

	/**
	 * 
	 */
	private DistanciaSpecification() {
	}
}
