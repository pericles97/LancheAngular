package br.edu.up.as.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Cliente;
import br.edu.up.as.service.ClienteService;
import br.edu.up.as.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarCliente {
	
	static Integer id;
	
	@Test
	public void testAcadastrarCliente() {
		
		Cliente c = new Cliente();
		c.setId(null);
		c.setNome("Cliente Teste");
		c.setCpf("1617156");
		
		try {
			new ClienteService().salvar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		
		assertEquals(true,c.getId() != null);
		id = c.getId();
	}
	
	@Test
	public void testBlistarCliente() {
		
		Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
		List<Cliente> clientes = clienteDao.listar();
		
		assertEquals(true, clientes.size()>0);
		
	}
	
	/*@Test
	public void testCalterarCliente() {
		Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
		Cliente c = clienteDao.buscarPorId(id);
		
		c.setNome("Cliente TesteAlterado");
		clienteDao.alterar(c);
		
		//c = clienteDao.buscarPorId(16);
		c = clienteDao.buscarPorId(id);
		
		assertEquals(true,c.getNome().equals("Cliente TesteAlterado"));
		
	}*/

	/*@Test
	public void testDremoverCliente() {
		Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
		Cliente c = clienteDao.buscarPorId(id);
		
		clienteDao.excluir(c);
		
		c = clienteDao.buscarPorId(id);
		
		assertEquals(true,c == null);
		
	}*/
	
}
