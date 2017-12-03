package br.edu.up.as.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Lanche {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String NomeLanche;
	private double ValorLanche;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNomeLanche() {
		return NomeLanche;
	}
	public void setNomeLanche(String nomeLanche) {
		NomeLanche = nomeLanche;
	}
	public double getValorLanche() {
		return ValorLanche;
	}
	public void setValorLanche(double valorLanche) {
		ValorLanche = valorLanche;
	}
}
