/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Organizador;
import com.bindot.runap.model.Organizador_;

/**
 * @author Cesar Zamorano
 *
 */
public class OrganizadorSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Organizador> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Organizador_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param webpage
	 * @return
	 */
	public static Specification<Organizador> likeToWebpage(String webpage) {
		return (root, query, builder) -> builder.like(root.get(Organizador_.webpage), "%" + webpage + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Organizador> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Organizador_.enabled), enabled);
	}

	/**
	 * 
	 */
	private OrganizadorSpecification() {
	}
}