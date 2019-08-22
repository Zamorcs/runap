/**
 * 
 */
package com.bindot.runap.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Calendario;
import com.bindot.runap.model.Calendario_;

/**
 * @author Cesar Zamorano
 *
 */
public class CalendarioSpecification {

	/**
	 * @param enabled
	 * @return
	 */
	public static Specification<Calendario> equalToEnabled(Boolean enabled) {
		return (root, query, builder) -> builder.equal(root.get(Calendario_.enabled), enabled);
	}

	/**
	 * 
	 */
	private CalendarioSpecification() {
	}
}
