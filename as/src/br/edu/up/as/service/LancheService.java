package br.edu.up.as.service;

import br.edu.up.as.dao.Dao;
import br.edu.up.as.dao.FactoryDao;
import br.edu.up.as.entidade.Lanche;

public class LancheService {
	
	public void salvar(Lanche l) throws ServiceException {
		
		if (l.getNomeLanche() == null || l.getNomeLanche().equals("")) {
			
			throw new 
			ServiceException("ERR01 - O lanche precisa ser preenchido.");
		}
		
		Dao<Lanche> lancheDao = FactoryDao.createLancheDao();
		lancheDao.salvar(l);
	}
	
	public void alterar(Lanche l) throws ServiceException {
		
		Dao<Lanche> lancheDao = FactoryDao.createLancheDao();
		lancheDao.alterar(l);
	}
	
	public void listar(Lanche l) throws ServiceException {
		
	}
	public void excluir(Lanche l) throws ServiceException {
		Dao<Lanche> lancheDao = FactoryDao.createLancheDao();
		lancheDao.excluir(l);
	}
}
