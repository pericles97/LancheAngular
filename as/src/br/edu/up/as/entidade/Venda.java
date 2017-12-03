package br.edu.up.as.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private Integer qtdItens;
	private double valorTotalVenda;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

	public double getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	/*
	 * private Integer IdLanche; private Integer IdCliente;
	 * 
	 * //import javax.persistence.ManyToOne;
	 * 
	 * @ManyToOne private Lanche lanche;
	 * 
	 * @ManyToOne private Cliente cliente;
	 */

}
