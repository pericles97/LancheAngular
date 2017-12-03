package br.edu.up.as.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.as.entidade.Cliente;

public class ClienteDao implements Dao<Cliente> {

	public void salvar(Cliente c) {
		EntityManager em = Conexao.getInstance();

		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

	}

	public void excluir(Cliente c) {
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(c));
		em.getTransaction().commit();
	}

	public void alterar(Cliente c) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}

	public List<Cliente> listar() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Cliente");
		
		return q.getResultList();
	}

	public Cliente buscarPorId(Integer id) {
		EntityManager em = Conexao.getInstance();
		Cliente c = em.find(Cliente.class, id);
		return c;
	}
}
