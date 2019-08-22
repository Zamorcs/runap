/**
 * 
 */
package com.bindot.runap.service.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Precio;
import com.bindot.runap.model.Precio_;

/**
 * @author Cesar Zamorano
 *
 */
public class PrecioSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Precio> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Precio_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param date
	 * @return
	 */
	public static Specification<Precio> greaterToFechaInicio(LocalDateTime date) {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Precio_.fechaInicio), date);
	}

	/**
	 * @param date
	 * @return
	 */
	public static Specification<Precio> lessToFechaFin(LocalDateTime date) {
		return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(Precio_.fechaFin), date);
	}

	/**
	 * @param moneda
	 * @return
	 */
	public static Specification<Precio> likeToMoneda(String moneda) {
		return (root, query, builder) -> builder.like(root.get(Precio_.moneda), "%" + moneda + "%");
	}

	/**
	 * @param monto
	 * @return
	 */
	public static Specification<Precio> equalToMonto(Long monto) {
		return (root, query, builder) -> builder.equal(root.get(Precio_.monto), "%" + monto + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Precio> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Precio_.enabled), enabled);
	}

	/**
	 * 
	 */
	private PrecioSpecification() {
	}
}