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
@Table(name = "tipo_corredor")
public class TipoCorredor extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = -6909001426257554021L;

	@Id
	@GeneratedValue
	@Column(name = "tipo_corredor_id")
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
		id = value;
	}

}
