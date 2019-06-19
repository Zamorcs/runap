package com.bindot.runap.service.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;
import com.bindot.runap.model.Carrera;
import com.bindot.runap.model.Carrera_;

/**
 * Spring Data specification for the Carrera entity.
 */
public class CarreraSpecification {
		
		public static Specification<Carrera> likeToNombre(String nombre) {
			return (root, query, builder) -> builder.like(root.get(Carrera_.nombre), "%" + nombre + "%");
		}
		
		public static Specification<Carrera> likeToDescripcion(String descripcion) {
			return (root, query, builder) -> builder.like(root.get(Carrera_.descripcion), "%" + descripcion + "%");
		}

		public static Specification<Carrera> likeToOrganizador(String organizador) {
			return (root, query, builder) -> builder.equal(root.get(Carrera_.organizador), "%" + organizador + "%");
		}
		
		public static Specification<Carrera> greaterToFechaInicio(LocalDateTime date) {
			return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Carrera_.fechaInicio), date);
		}
		
		public static Specification<Carrera> lessToFechaFin(LocalDateTime date) {
			return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(Carrera_.fechaFin), date);
		}
		
		public static Specification<Carrera> equalToEnabled(Boolean enabled) {
			return (root, query, builder) -> builder.equal(root.get(Carrera_.enabled), enabled);
		}

		public static Specification<Carrera> equalToFechaInicioInscripcion(LocalDateTime date) {
			return (root, query, builder) -> builder.equal(root.get(Carrera_.fechaInicioInscripcion), date);
		}
		
		private CarreraSpecification() {
		}

}
