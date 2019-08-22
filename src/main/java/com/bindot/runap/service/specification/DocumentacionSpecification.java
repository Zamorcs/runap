package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Documentacion;
import com.bindot.runap.model.Documentacion_;

/**
 * @author Cesar Zamorano
 *
 */
public class DocumentacionSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Documentacion> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Documentacion_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param obligatorio
	 * @return
	 */
	public static Specification<Documentacion> equalToObligatorio(Boolean obligatorio) {
		return (root, query, builder) -> builder.equal(root.get(Documentacion_.obligatorio), obligatorio);
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Documentacion> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Documentacion_.enabled), enabled);
	}

	/**
	 * 
	 */
	private DocumentacionSpecification() {
	}
}
