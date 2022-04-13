package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Auto {
	
	@Id
	private String targa;
	@Column
	private String colore;
	
	@Column(name = "tariffa_noleggio")
	private int tariffaNoleggio;
	
	@OneToMany(mappedBy="auto")
	private List<Noleggio> noleggi;

	
	public String getColore() {
		return colore;
	}
	
	public String getTarga() {
		return targa;
	}
	
	public int getTariffaNoleggio() {
		return tariffaNoleggio;
	}
	
	
	public List<Noleggio> getNoleggi() {
		return noleggi;
	}
	
	
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public void setTariffaNoleggio(int tariffaNoleggio) {
		this.tariffaNoleggio = tariffaNoleggio;
	}

	public void setNoleggi(List<Noleggio> noleggi) {
		this.noleggi = noleggi;
	}
	
	
	@Override
	public String toString() {
		return "Auto [targa=" + targa + ", colore=" + colore + ", tariffaNoleggio=" + tariffaNoleggio + "]";
	}
	
}
