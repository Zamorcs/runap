/**
 * 
 */
package com.bindot.runap.service.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.RecKit;
import com.bindot.runap.model.RecKit_;

/**
 * @author Cesar Zamorano
 *
 */
public class RecKitSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<RecKit> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(RecKit_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param date
	 * @return
	 */
	public static Specification<RecKit> greaterToFechaInicio(LocalDateTime date) {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(RecKit_.fechaInicio), date);
	}

	/**
	 * @param date
	 * @return
	 */
	public static Specification<RecKit> lessToFechaFin(LocalDateTime date) {
		return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(RecKit_.fechaFin), date);
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<RecKit> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(RecKit_.enabled), enabled);
	}

	/**
	 * 
	 */
	private RecKitSpecification() {
	}
}
