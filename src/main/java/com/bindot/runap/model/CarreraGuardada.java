package com.bindot.runap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cesar Zamorano
 *
 */
@Entity
@Table(name = "carrera_guardada")
public class CarreraGuardada extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = -8873166354022929202L;
	
	@Id
	@GeneratedValue
	@Column(name = "carrera_guardada_id")
	private Long id;

	@Column(name = "carrera_id")
	private Long carreraId;

	private Boolean inscripto;

	private Boolean enabled;

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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
