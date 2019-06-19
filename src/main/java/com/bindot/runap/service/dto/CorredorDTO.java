package com.bindot.runap.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Cesar Zamorano
 *
 */
public class CorredorDTO implements Serializable {

	private static final long serialVersionUID = -2162360700192391338L;

	private Long id;

	private String nombre;

	private String apellido;

	private LocalDateTime fechaNacimiento;

	private Long tipoCorredorId;

	private Long sexoId;

	private String social;

	private String email;

	private LocalDateTime fechaRegistro;

	private LocalDateTime fechaUltimoLogin;

	private Long avatarId;

	private Long runningTeamId;

	private Long friendlistId;

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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the tipoCorredorId
	 */
	public Long getTipoCorredorId() {
		return tipoCorredorId;
	}

	/**
	 * @param tipoCorredorId
	 *            the tipoCorredorId to set
	 */
	public void setTipoCorredorId(Long tipoCorredorId) {
		this.tipoCorredorId = tipoCorredorId;
	}

	/**
	 * @return the sexoId
	 */
	public Long getSexoId() {
		return sexoId;
	}

	/**
	 * @param sexoId
	 *            the sexoId to set
	 */
	public void setSexoId(Long sexoId) {
		this.sexoId = sexoId;
	}

	/**
	 * @return the social
	 */
	public String getSocial() {
		return social;
	}

	/**
	 * @param social
	 *            the social to set
	 */
	public void setSocial(String social) {
		this.social = social;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fechaRegistro
	 */
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro
	 *            the fechaRegistro to set
	 */
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaUltimoLogin
	 */
	public LocalDateTime getFechaUltimoLogin() {
		return fechaUltimoLogin;
	}

	/**
	 * @param fechaUltimoLogin
	 *            the fechaUltimoLogin to set
	 */
	public void setFechaUltimoLogin(LocalDateTime fechaUltimoLogin) {
		this.fechaUltimoLogin = fechaUltimoLogin;
	}

	/**
	 * @return the avatarId
	 */
	public Long getAvatarId() {
		return avatarId;
	}

	/**
	 * @param avatarId
	 *            the avatarId to set
	 */
	public void setAvatarId(Long avatarId) {
		this.avatarId = avatarId;
	}

	/**
	 * @return the runningTeamId
	 */
	public Long getRunningTeamId() {
		return runningTeamId;
	}

	/**
	 * @param runningTeam
	 *            the runningTeam to set
	 */
	public void setRunningTeamId(Long runningTeamId) {
		this.runningTeamId = runningTeamId;
	}

	/**
	 * @return the friendlistId
	 */
	public Long getFriendlistId() {
		return friendlistId;
	}

	/**
	 * @param friendlistId
	 *            the friendlistId to set
	 */
	public void setFriendlistId(Long friendlistId) {
		this.friendlistId = friendlistId;
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
