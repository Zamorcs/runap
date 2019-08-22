/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.CarreraGuardada;
import com.bindot.runap.model.CarreraGuardada_;

/**
 * @author Cesar Zamorano
 *
 */
public class CarreraGuardadaSpecification {

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<CarreraGuardada> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(CarreraGuardada_.enabled), enabled);
	}

	/**
	 * @param inscripto
	 * @return
	 */
	public static Specification<CarreraGuardada> equalToInscripto(Boolean inscripto) {
		return (root, query, builder) -> builder.equal(root.get(CarreraGuardada_.inscripto), inscripto);
	}

	/**
	 * 
	 */
	private CarreraGuardadaSpecification() {
	}
}
