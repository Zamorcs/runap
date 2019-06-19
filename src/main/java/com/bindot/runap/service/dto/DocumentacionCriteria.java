package com.bindot.runap.service.dto;

import java.io.Serializable;

/**
 * @author Cesar Zamorano
 *
 */
public class DocumentacionCriteria implements Serializable {


	private static final long serialVersionUID = -1066826276624226086L;

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

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

}
