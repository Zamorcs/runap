package com.bindot.runap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Cesar Zamorano
 *
 */
@Entity
public class Documentacion extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = 2526496910665519946L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@Column(name = "documentacion_id")
	private Long id;

	private String descripcion;

	private Boolean obligatorio;

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
	 * @return the obligatorio
	 */
	public Boolean getObligatorio() {
		return obligatorio;
	}

	/**
	 * @param obligatorio
	 *            the obligatorio to set
	 */
	public void setObligatorio(Boolean obligatorio) {
		this.obligatorio = obligatorio;
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
