package com.bindot.runap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Cesar Zamorano
 *
 */
@Entity
public class Calendario extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = -8740244507038927725L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@Column(name = "calendario_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_calendario_id")
	private EstadoCalendario estadoCalendario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="corredor_id")
	private Corredor corredor;

	@ManyToMany
	@JoinTable(name = "lista_carreras", joinColumns = @JoinColumn(name = "carrera_guardada_id"), inverseJoinColumns = @JoinColumn(name = "calendario_id"))
	private List<CarreraGuardada> listaCarrerasGuardadas;

	private Boolean enabled;

	/**
	 * @return the estadoCalendario
	 */
	public EstadoCalendario getEstadoCalendario() {
		return estadoCalendario;
	}

	/**
	 * @param estadoCalendario
	 *            the estadoCalendario to set
	 */
	public void setEstadoCalendario(EstadoCalendario estadoCalendario) {
		this.estadoCalendario = estadoCalendario;
	}

	/**
	 * @return the corredor
	 */
	public Corredor getCorredor() {
		return corredor;
	}

	/**
	 * @param corredor
	 *            the corredor to set
	 */
	public void setCorredor(Corredor corredor) {
		this.corredor = corredor;
	}

	/**
	 * @return the listaCarrerasGuardadas
	 */
	public List<CarreraGuardada> getListaCarrerasGuardadas() {
		return listaCarrerasGuardadas;
	}

	/**
	 * @param lista_carreras_guardadas
	 *            the listaCarrerasGuardadas to set
	 */
	public void setListaCarrerasGuardadas(List<CarreraGuardada> listaCarrerasGuardadas) {
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long value) {
		id = value;
	}

}
