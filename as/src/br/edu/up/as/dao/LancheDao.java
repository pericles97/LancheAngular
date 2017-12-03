package br.edu.up.as.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.as.entidade.Lanche;

public class LancheDao implements Dao<Lanche> {

	public void salvar(Lanche l) {
		// TODO Auto-generated method stub
		EntityManager em = Conexao.getInstance();

		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
	}

	public void excluir(Lanche l) {
		// TODO Auto-generated method stub
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(l));
		em.getTransaction().commit();
		
	}

	public void alterar(Lanche l) {
		// TODO Auto-generated method stub
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
	}

	public List<Lanche> listar() {
		// TODO Auto-generated method stub
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Lanche");
		return q.getResultList();
	}

	public Lanche buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		EntityManager em = Conexao.getInstance();
		Lanche l = em.find(Lanche.class, id);
		return l;
	}

}
