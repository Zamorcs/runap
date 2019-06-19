package com.bindot.runap.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Cesar Zamorano
 *
 */
@Entity
public class Carrera extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = -5799237538549476752L;

	@Id
	@GeneratedValue
	@Column(name = "carrera_id")
	private Long id;

	private String nombre;

	private String descripcion;

	private String organizador;

	@Column(name = "fecha_inicio")
	private LocalDateTime fechaInicio;

	@Column(name = "fecha_fin")
	private LocalDateTime fechaFin;

	@Column(name = "tipo_carrera")
	private TipoCarrera tipoCarrera;

	private String webpage;

	private String pais;

	private Imagen imagen;

	@Column(name = "fecha_inicio_inscripcion")
	private LocalDateTime fechaInicioInscripcion;

	private String novedades;

	private Recorrido recorrido;

	private Formato formato;

	@ManyToMany
	@JoinTable(name = "lista_distancias", joinColumns = @JoinColumn(name = "distancia_id"), inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	private List<Distancia> listaDistancias;

	@ManyToMany
	@JoinTable(name = "lista_precios", joinColumns = @JoinColumn(name = "precio_id"), inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	private List<Precio> listaPrecios;

	@ManyToMany
	@JoinTable(name = "lista_direcciones", joinColumns = @JoinColumn(name = "direccion_id"), inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	private List<Direccion> listaDirecciones;

	@ManyToMany
	@JoinTable(name = "lista_rec_kits", joinColumns = @JoinColumn(name = "rec_kit_id"), inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	private List<RecKit> listaRecKits;

	private Boolean enabled;

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
	 * @return the tipoCarrera
	 */
	public TipoCarrera getTipoCarrera() {
		return tipoCarrera;
	}

	/**
	 * @param tipoCarrera
	 *            the tipoCarrera to set
	 */
	public void setTipoCarrera(TipoCarrera tipoCarrera) {
		this.tipoCarrera = tipoCarrera;
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
	 * @return the imagen
	 */
	public Imagen getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
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
	 * @return the recorrido
	 */
	public Recorrido getRecorrido() {
		return recorrido;
	}

	/**
	 * @param recorrido
	 *            the recorrido to set
	 */
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

	/**
	 * @return the formato
	 */
	public Formato getFormato() {
		return formato;
	}

	/**
	 * @param formato
	 *            the formato to set
	 */
	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	/**
	 * @return the listaDistancias
	 */
	public List<Distancia> getListaDistancias() {
		return listaDistancias;
	}

	/**
	 * @param listaDistancias
	 *            the listaDistancias to set
	 */
	public void setListaDistancias(List<Distancia> listaDistancias) {
		this.listaDistancias = listaDistancias;
	}

	/**
	 * @return the listaPrecios
	 */
	public List<Precio> getListaPrecios() {
		return listaPrecios;
	}

	/**
	 * @param listaPrecios
	 *            the listaPrecios to set
	 */
	public void setListaPrecios(List<Precio> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}

	/**
	 * @return the listaDirecciones
	 */
	public List<Direccion> getListaDirecciones() {
		return listaDirecciones;
	}

	/**
	 * @param listaDirecciones
	 *            the listaDirecciones to set
	 */
	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	/**
	 * @return the listaRecKits
	 */
	public List<RecKit> getListaRecKits() {
		return listaRecKits;
	}

	/**
	 * @param listaRecKits
	 *            the listaRecKits to set
	 */
	public void setListaRecKits(List<RecKit> listaRecKits) {
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long value) {
		id = value;
	}

}
