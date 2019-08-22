package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Direccion;
import com.bindot.runap.model.Direccion_;

/**
 * @author Cesar Zamorano
 *
 */
public class DireccionSpecification {

	public static Specification<Direccion> likeToCalle(String calle) {
		return (root, query, builder) -> builder.like(root.get(Direccion_.calle), "%" + calle + "%");
	}
	
	public static Specification<Direccion> likeToCodigoPostal(String codigoPostal) {
		return (root, query, builder) -> builder.like(root.get(Direccion_.codigoPostal), "%" + codigoPostal + "%");
	}
	
	public static Specification<Direccion> likeToLocalidad(String localidad) {
		return (root, query, builder) -> builder.like(root.get(Direccion_.localidad), "%" + localidad + "%");
	}
	
	public static Specification<Direccion> likeToNotas(String notas) {
		return (root, query, builder) -> builder.like(root.get(Direccion_.notas), "%" + notas + "%");
	}
	
	public static Specification<Direccion> equalToNumero(Long numero) {
		return (root, query, builder) -> builder.equal(root.get(Direccion_.numero), "%" + numero + "%");
	}
	
	public static Specification<Direccion> likeToPais(String pais) {
		return (root, query, builder) -> builder.like(root.get(Direccion_.pais), "%" + pais + "%");
	}
	
	public static Specification<Direccion> likeToProvincia(String provincia) {
		return (root, query, builder) -> builder.like(root.get(Direccion_.provincia), "%" + provincia + "%");
	}

	public static Specification<Direccion> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Direccion_.enabled), enabled);
	}

	private DireccionSpecification() {
	}
}
