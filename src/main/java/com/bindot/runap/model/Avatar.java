package com.bindot.runap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Cesar Zamorano
 *
 */
@Entity
public class Avatar extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = 444175647302288102L;

	@Id
	@GeneratedValue
	@Column(name = "avatar_id")
	private Long id;

	private String descripcion;

	private Boolean enabled;

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public void setId(Long value) {
		id= value;
	}
	
}
