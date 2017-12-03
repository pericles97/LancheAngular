package br.edu.up.as.service;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Venda;

public class VendaService {
	
	public void salvar(Venda v) throws ServiceException {
		
		if (v.getValorTotalVenda() == 0) {
			
			throw new 
			ServiceException("ERR01 - O valor da venda precisa ser preenchido.");
		}
		
		Dao<Venda> vendaDao = FactoryDao.createVendaDao();
		vendaDao.salvar(v);
	}
	
	public void alterar(Venda v) throws ServiceException {
		
		Dao<Venda> vendaDao = FactoryDao.createVendaDao();
		vendaDao.alterar(v);	
	}
	
	public void listar(Venda v) throws ServiceException {
		
	}
	public void excluir(Venda v) throws ServiceException {
		Dao<Venda> vendaDao = FactoryDao.createVendaDao();
		vendaDao.excluir(v);
	}
	
}
