package com.sisvuelo.aplication.model;

//import java.sql.Date;


//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_EstatusReserva")
public class EstatusReserva {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_Estatus_Reserva")
	private Integer id;
	
	@Column(name = "Estatus", nullable = false, length = 50)
	private String estatus;


	


	public EstatusReserva() {
		super();
	}

	public EstatusReserva(Integer id, String estatus) {
		super();
		this.id = id;
		this.estatus = estatus;
				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEstatus() {
		return estatus;
	}

	public void setNombreClase(String estatus) {
		this.estatus = estatus;
	}

}