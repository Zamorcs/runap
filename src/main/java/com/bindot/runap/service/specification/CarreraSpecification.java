package com.bindot.runap.service.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Carrera;
import com.bindot.runap.model.Carrera_;

/**
 * Spring Data specification for the Carrera entity.
 * 
 * @author JOJO
 *
 */
public class CarreraSpecification {

	/**
	 * @param nombre
	 * @return
	 */
	public static Specification<Carrera> likeToNombre(String nombre) {
		return (root, query, builder) -> builder.like(root.get(Carrera_.nombre), "%" + nombre + "%");
	}

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Carrera> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Carrera_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param date
	 * @return
	 */
	public static Specification<Carrera> greaterToFechaInicio(LocalDateTime date) {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Carrera_.fechaInicio), date);
	}

	/**
	 * @param date
	 * @return
	 */
	public static Specification<Carrera> lessToFechaFin(LocalDateTime date) {
		return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(Carrera_.fechaFin), date);
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Carrera> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Carrera_.enabled), enabled);
	}

	/**
	 * @param date
	 * @return
	 */
	public static Specification<Carrera> equalToFechaInicioInscripcion(LocalDateTime date) {
		return (root, query, builder) -> builder.equal(root.get(Carrera_.fechaInicioInscripcion), date);
	}

	private CarreraSpecification() {
	}

}
