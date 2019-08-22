/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.TipoCorredor;
import com.bindot.runap.model.TipoCorredor_;

/**
 * @author Cesar Zamorano
 *
 */
public class TipoCorredorSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<TipoCorredor> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(TipoCorredor_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<TipoCorredor> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(TipoCorredor_.enabled), enabled);
	}

	/**
	 * 
	 */
	private TipoCorredorSpecification() {
	}
}
