package com.easyplus.easy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name="app_user")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="app_user")
	@NotBlank(message = "El usuario no puede ser vacio")
	private String appUser;
	
	@Column(name="nombre")
	@NotBlank(message = "El nombre de usuario no puede ser vacio")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre solo puede contener letras")
	private String nombre;
	
	@Column(name="apellido")
	@NotBlank(message = "El apellido de usuario no puede ser vacio")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "El apellido solo puede contener letras")
	private String apellido;
	
	@Column(name="email")
	@NotBlank(message = "El email no puedo ser vacio")
	@Email(message = "El formato del email no es válido")
	private String email;
	
	@Column(name="estado")
	@NotBlank(message = "El estado no puedo ser vacio")
	private String estado;
	
	@Column(name="password")
	@NotBlank(message = "La contraseña no puedo ser vacio")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppUser() {
		return appUser;
	}

	public void setAppUser(String appUser) {
		this.appUser = appUser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
