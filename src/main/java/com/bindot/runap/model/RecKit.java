package com.bindot.runap.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bindot.runap.model.util.LocalDateTimeConverter;

/**
 * @author Cesar Zamorano
 *
 */
@Entity
@Table(name = "rec_kit")
public class RecKit extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = 2389052538665524358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "rec_kit_id")
	private Long id;

	private String descripcion;

	@Column(name = "fecha_inicio")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime fechaInicio;

	@Column(name = "fecha_fin")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime fechaFin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documentacion_id")
	private Documentacion documentacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "direccion_id")
	private Direccion direccion;

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
	 * @return the documentacion
	 */
	public Documentacion getDocumentacion() {
		return documentacion;
	}

	/**
	 * @param documentacion
	 *            the documentacion to set
	 */
	public void setDocumentacion(Documentacion documentacion) {
		this.documentacion = documentacion;
	}

	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long value) {
		id = value;
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
