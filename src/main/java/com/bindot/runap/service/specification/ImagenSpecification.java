/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Imagen;
import com.bindot.runap.model.Imagen_;

/**
 * @author Cesar Zamorano
 *
 */
public class ImagenSpecification {

	/**
	 * @param descripcion
	 * @return
	 */
	public static Specification<Imagen> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Imagen_.descripcion), "%" + descripcion + "%");
	}

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Imagen> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Imagen_.enabled), enabled);
	}

	/**
	 * 
	 */
	private ImagenSpecification() {
	}
}
