package com.bindot.runap.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Cesar Zamorano
 *
 */
@Entity
public class Corredor extends ARunapEntity implements Serializable {

	private static final long serialVersionUID = -8135018820623410415L;

	@Id
	@GeneratedValue
	@Column(name = "corredor_id")
	private Long id;

	private String nombre;

	private String apellido;

	@Column(name = "fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@Column(name = "tipo_corredor")
	private TipoCorredor tipoCorredor;

	private Sexo sexo;

	private String social;

	private String email;

	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;

	@Column(name = "fecha_ultimo_login")
	private LocalDateTime fechaUltimoLogin;

	private Avatar avatar;

	@Column(name = "running_team")
	private Long runningTeam;

	private Long friendlist;

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
	 * @return the tipoCorredor
	 */
	public TipoCorredor getTipoCorredor() {
		return tipoCorredor;
	}

	/**
	 * @param tipoCorredor
	 *            the tipoCorredor to set
	 */
	public void setTipoCorredor(TipoCorredor tipoCorredor) {
		this.tipoCorredor = tipoCorredor;
	}

	/**
	 * @return the sexo
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
	 * @return the avatar
	 */
	public Avatar getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the runningTeam
	 */
	public Long getRunningTeam() {
		return runningTeam;
	}

	/**
	 * @param runningTeam
	 *            the runningTeam to set
	 */
	public void setRunningTeam(Long runningTeam) {
		this.runningTeam = runningTeam;
	}

	/**
	 * @return the friendlist
	 */
	public Long getFriendlist() {
		return friendlist;
	}

	/**
	 * @param friendlist
	 *            the friendlist to set
	 */
	public void setFriendlist(Long friendlist) {
		this.friendlist = friendlist;
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
