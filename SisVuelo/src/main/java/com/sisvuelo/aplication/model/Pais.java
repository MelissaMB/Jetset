package com.sisvuelo.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PAIS")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_pais")
	private Integer id;

	@Column(name = "codigo_pais", nullable = false, length = 3)
	private String codigo;

	@Column(name = "nombre_pais", nullable = false, length = 50)
	private String nombre;

	public Pais() {
		super();
	}

	public Pais(Integer id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
