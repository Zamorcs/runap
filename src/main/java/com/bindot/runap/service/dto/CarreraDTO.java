package com.bindot.runap.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Cesar Zamorano
 *
 */
public class CarreraDTO implements Serializable {

	private static final long serialVersionUID = -8030976174580353213L;

	private Long id;

	private String nombre;

	private String descripcion;

	private String organizador;

	private LocalDateTime fechaInicio;

	private LocalDateTime fechaFin;

	private Long tipoCarreraId;

	private String webpage;

	private String pais;

	private Long imagenId;

	private LocalDateTime fechaInicioInscripcion;

	private String novedades;

	private Long recorridoId;

	private Long formatoId;

	private List<Long> listaDistancias;

	private List<Long> listaPrecios;

	private List<Long> listaDirecciones;

	private List<Long> listaRecKits;

	private Boolean enabled;

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the organizador
	 */
	public String getOrganizador() {
		return organizador;
	}

	/**
	 * @param organizador
	 *            the organizador to set
	 */
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
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
	 * @return the tipoCarreraId
	 */
	public Long getTipoCarreraId() {
		return tipoCarreraId;
	}

	/**
	 * @param tipoCarreraId
	 *            the tipoCarreraId to set
	 */
	public void setTipoCarreraId(Long tipoCarreraId) {
		this.tipoCarreraId = tipoCarreraId;
	}

	/**
	 * @return the webpage
	 */
	public String getWebpage() {
		return webpage;
	}

	/**
	 * @param webpage
	 *            the webpage to set
	 */
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the imagenId
	 */
	public Long getImagenId() {
		return imagenId;
	}

	/**
	 * @param imagenId
	 *            the imagenId to set
	 */
	public void setImagenId(Long imagenId) {
		this.imagenId = imagenId;
	}

	/**
	 * @return the fechaInicioInscripcion
	 */
	public LocalDateTime getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	/**
	 * @param fechaInicioInscripcion
	 *            the fechaInicioInscripcion to set
	 */
	public void setFechaInicioInscripcion(LocalDateTime fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	/**
	 * @return the novedades
	 */
	public String getNovedades() {
		return novedades;
	}

	/**
	 * @param novedades
	 *            the novedades to set
	 */
	public void setNovedades(String novedades) {
		this.novedades = novedades;
	}

	/**
	 * @return the recorridoId
	 */
	public Long getRecorridoId() {
		return recorridoId;
	}

	/**
	 * @param recorridoId
	 *            the recorridoId to set
	 */
	public void setRecorridoId(Long recorridoId) {
		this.recorridoId = recorridoId;
	}

	/**
	 * @return the formatoId
	 */
	public Long getFormatoId() {
		return formatoId;
	}

	/**
	 * @param formatoId
	 *            the formatoId to set
	 */
	public void setFormatoId(Long formatoId) {
		this.formatoId = formatoId;
	}

	/**
	 * @return the listaDistancias
	 */
	public List<Long> getListaDistancias() {
		return listaDistancias;
	}

	/**
	 * @param listaDistancias
	 *            the listaDistancias to set
	 */
	public void setListaDistancias(List<Long> listaDistancias) {
		this.listaDistancias = listaDistancias;
	}

	/**
	 * @return the listaPrecios
	 */
	public List<Long> getListaPrecios() {
		return listaPrecios;
	}

	/**
	 * @param listaPrecios
	 *            the listaPrecios to set
	 */
	public void setListaPrecios(List<Long> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}

	/**
	 * @return the listaDirecciones
	 */
	public List<Long> getListaDirecciones() {
		return listaDirecciones;
	}

	/**
	 * @param listaDirecciones
	 *            the listaDirecciones to set
	 */
	public void setListaDirecciones(List<Long> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	/**
	 * @return the listaRecKits
	 */
	public List<Long> getListaRecKits() {
		return listaRecKits;
	}

	/**
	 * @param listaRecKits
	 *            the listaRecKits to set
	 */
	public void setListaRecKits(List<Long> listaRecKits) {
		this.listaRecKits = listaRecKits;
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
