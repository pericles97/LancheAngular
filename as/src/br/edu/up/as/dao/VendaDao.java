package br.edu.up.as.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.as.entidade.Venda;

public class VendaDao implements Dao<Venda> {

	public void salvar(Venda v) {
		EntityManager em = Conexao.getInstance();

		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

	public void excluir(Venda v) {
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(v));
		em.getTransaction().commit();
		
	}

	public void alterar(Venda v) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
	}

	public List<Venda> listar() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Venda");
		return q.getResultList();
	}

	public Venda buscarPorId(Integer id) {
		EntityManager em = Conexao.getInstance();
		Venda v = em.find(Venda.class, id);
		return v;
	}
}
