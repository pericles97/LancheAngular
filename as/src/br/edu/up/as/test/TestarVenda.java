package br.edu.up.as.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.dao.VendaDao;
import br.edu.up.as.entidade.Venda;
import br.edu.up.as.service.ServiceException;
import br.edu.up.as.service.VendaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarVenda {
	
	static Integer id;
	@Test
	public void testAcadastrarVenda() {
		
		Venda v = new Venda();
		v.setId(null);
		v.setQtdItens(3);
		/*v.setIdLanche(5);
		v.setIdCliente(5);*/
		v.setValorTotalVenda(17.00);
		
		try {
			new VendaService().salvar(v);;
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true,v.getId() != null);
		id = v.getId();
	}
	
	@Test
	public void testBlistarVenda() {
		
		List<Venda> venda = new VendaDao().listar();
		
		assertEquals(true, venda.size()>0);
		
	}
	
	@Test
	public void testCalterarVenda() {
		Dao<Venda> vendaDao = FactoryDao.createVendaDao();
		Venda v = vendaDao.buscarPorId(id);
		
		v.setValorTotalVenda(17.00);
		vendaDao.alterar(v);
		
		//c = clienteDao.buscarPorId(16);
		v = vendaDao.buscarPorId(id);
		
		assertEquals(true,v.getValorTotalVenda() == 17.00);
		
	}

	/*@Test
	public void testDremoverVenda() {
		Dao<Venda> vendaDao = FactoryDao.createVendaDao();
		Venda v = vendaDao.buscarPorId(id);
		
		vendaDao.excluir(v);
		
		v = vendaDao.buscarPorId(id);
		
		assertEquals(true,v == null);
		
	}*/
	
}
