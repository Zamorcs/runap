/**
 * 
 */
package com.bindot.runap.service.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Corredor;
import com.bindot.runap.model.Corredor_;

/**
 * @author Cesar Zamorano
 *
 */
public class CorredorSpecification {

	/**
	 * @param apellido
	 * @return
	 */
	public static Specification<Corredor> likeToApellido(String apellido) {
		return (root, query, builder) -> builder.like(root.get(Corredor_.apellido), "%" + apellido + "%");
	}

	/**
	 * @param nombre
	 * @return
	 */
	public static Specification<Corredor> likeToNombre(String nombre) {
		return (root, query, builder) -> builder.like(root.get(Corredor_.nombre), "%" + nombre + "%");
	}

	/**
	 * @param email
	 * @return
	 */
	public static Specification<Corredor> likeToEmail(String email) {
		return (root, query, builder) -> builder.like(root.get(Corredor_.email), "%" + email + "%");
	}

	/**
	 * @param social
	 * @return
	 */
	public static Specification<Corredor> likeToSocial(String social) {
		return (root, query, builder) -> builder.like(root.get(Corredor_.social), "%" + social + "%");
	}

	/**
	 * @param fechaNacimiento
	 * @return
	 */
	public static Specification<Corredor> greaterToFechaNacimiento(LocalDateTime date) {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Corredor_.fechaNacimiento), date);
	}

	/**
	 * @param fechaRegistro
	 * @return
	 */
	public static Specification<Corredor> greaterThanFechaRegistro(LocalDateTime date) {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Corredor_.fechaRegistro), date);
	}

	/**
	 * @param fechaUltimoLogin
	 * @return
	 */
	public static Specification<Corredor> greaterThanFechaUltimoLogin(LocalDateTime date) {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Corredor_.fechaUltimoLogin), date);
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Corredor> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Corredor_.enabled), enabled);
	}

	/**
	 * 
	 */
	private CorredorSpecification() {
	}

}
