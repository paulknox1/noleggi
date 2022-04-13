package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Noleggio {
	
	@Id
	@Column(name = "id_nol")
	private Long idNoleggio;

	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="targa")
	private Auto auto;
	
	@ManyToOne
	@JoinColumn(name="cliente")//nome colonna fk
	private Cliente cliente;
	

	
	public Auto getAuto() {
		return auto;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Date getData() {
		return data;
	}
	
	public Long getIdNoleggio() {
		return idNoleggio;
	}
	
	public void setIdNoleggio(Long idNoleggio) {
		this.idNoleggio = idNoleggio;
	}
	
	public void setData(Date data) {
		this.data = data;
	}


	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	

	

}
