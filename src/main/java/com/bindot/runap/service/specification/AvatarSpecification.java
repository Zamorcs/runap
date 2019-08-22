package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Avatar;
import com.bindot.runap.model.Avatar_;

/**
 * Spring Data specification for the Carrera entity.
 */
public class AvatarSpecification {

	public static Specification<Avatar> likeToDescripcion(String descripcion) {
		return (root, query, builder) -> builder.like(root.get(Avatar_.descripcion), "%" + descripcion + "%");
	}

	public static Specification<Avatar> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Avatar_.enabled), enabled);
	}

	private AvatarSpecification() {
	}

}
