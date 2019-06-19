package com.bindot.runap.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Cesar Zamorano
 *
 */
public class RecKitDTO implements Serializable {

	private static final long serialVersionUID = 6887728887941129080L;

	private Long id;

	private String descripcion;

	private LocalDateTime fechaInicio;

	private LocalDateTime fechaFin;

	private Long documentacionId;

	private Long direccionId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the fechaInicio
	 */
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the documentacionId
	 */
	public Long getDocumentacionId() {
		return documentacionId;
	}

	/**
	 * @param documentacionId
	 *            the documentacionId to set
	 */
	public void setDocumentacionId(Long documentacionId) {
		this.documentacionId = documentacionId;
	}

	/**
	 * @return the direccionId
	 */
	public Long getDireccionId() {
		return direccionId;
	}

	/**
	 * @param direccionId
	 *            the direccionId to set
	 */
	public void setDireccionId(Long direccionId) {
		this.direccionId = direccionId;
	}

}
