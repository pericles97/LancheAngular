package br.edu.up.as.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.dao.LancheDao;
import br.edu.up.as.entidade.Lanche;
import br.edu.up.as.service.LancheService;
import br.edu.up.as.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarLanche {
	
	static Integer id;
	@Test
	public void testAcadastrarLanche() {
		
		Lanche l = new Lanche();
		l.setId(null);
		l.setNomeLanche("Lanche Teste");
		l.setValorLanche(8.00);
		
		try {
			new LancheService().salvar(l);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true,l.getId() != null);
		id = l.getId();
	}
	
	@Test
	public void testBlistarLanche() {
		
		List<Lanche> lanches = new LancheDao().listar();
		
		assertEquals(true, lanches.size()>0);
		
	}
	
	@Test
	public void testCalterarLanche() {
		Dao<Lanche> lancheDao = FactoryDao.createLancheDao();
		Lanche l = lancheDao.buscarPorId(id);
		
		l.setNomeLanche("Lanche TesteAlterado");
		l.setValorLanche(5.00);
		lancheDao.alterar(l);
		
		//c = clienteDao.buscarPorId(16);
		l = lancheDao.buscarPorId(id);
		
		assertEquals(true,l.getNomeLanche().equals("Lanche TesteAlterado"));
		assertEquals(true,l.getValorLanche() == 5.00);
		
	}

	/*@Test
	public void testDremoverLanche() {
		Dao<Lanche> lancheDao = FactoryDao.createLancheDao();
		Lanche l = lancheDao.buscarPorId(id);
		
		lancheDao.excluir(l);
		
		l = lancheDao.buscarPorId(id);
		
		assertEquals(true,l == null);
		
	}*/
}
