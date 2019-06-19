package com.bindot.runap.service.dto;

import java.io.Serializable;

/**
 * @author Cesar Zamorano
 *
 */
public class CarreraGuardadaCriteria implements Serializable {

	private static final long serialVersionUID = -8030976174580353213L;

	private Long id;
	
	private Long carreraId;

	private Boolean inscripto;

	private Boolean enabled;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the carreraId
	 */
	public Long getCarreraId() {
		return carreraId;
	}

	/**
	 * @param carreraId
	 *            the carreraId to set
	 */
	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
	}

	/**
	 * @return the inscripto
	 */
	public Boolean getInscripto() {
		return inscripto;
	}

	/**
	 * @param inscripto
	 *            the inscripto to set
	 */
	public void setInscripto(Boolean inscripto) {
		this.inscripto = inscripto;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
