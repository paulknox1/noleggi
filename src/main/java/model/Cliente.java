package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;

	
	@Column(name = "nome")
	private String nomeCliente;
	
	@OneToMany(mappedBy="cliente")  //nome attributo nell'entity noleggio
	private List<Noleggio> noleggi;

	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public List<Noleggio> getNoleggi() {
		return noleggi;
	}
	
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public void setNoleggi(List<Noleggio> noleggi) {
		this.noleggi = noleggi;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + "]";
	}
	
}
