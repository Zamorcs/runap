package com.bindot.runap.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Cesar Zamorano
 *
 */
public class CalendarioDTO implements Serializable {

	private static final long serialVersionUID = 3300744402678937897L;

	private Long id;

	private Long estadoCalendarioId;

	private Long corredorId;

	private List<Long> listaCarrerasGuardadas;

	private Boolean enabled;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param Id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the estadoCalendarioId
	 */
	public Long getEstadoCalendarioId() {
		return estadoCalendarioId;
	}

	/**
	 * @param estadoCalendarioId
	 *            the estadoCalendarioId to set
	 */
	public void setEstadoCalendarioId(Long estadoCalendarioId) {
		this.estadoCalendarioId = estadoCalendarioId;
	}

	/**
	 * @return the corredorId
	 */
	public Long getCorredorId() {
		return corredorId;
	}

	/**
	 * @param corredorId
	 *            the corredorId to set
	 */
	public void setCorredorId(Long corredorId) {
		this.corredorId = corredorId;
	}

	/**
	 * @return the listaCarrerasGuardadas
	 */
	public List<Long> getListaCarrerasGuardadas() {
		return listaCarrerasGuardadas;
	}

	/**
	 * @param listaCarrerasGuardadas
	 *            the listaCarrerasGuardadas to set
	 */
	public void setListaCarrerasGuardadas(List<Long> listaCarrerasGuardadas) {
		this.listaCarrerasGuardadas = listaCarrerasGuardadas;
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
