package br.edu.up.as.dao;

import br.edu.up.as.entidade.Cliente;
import br.edu.up.as.entidade.Lanche;
import br.edu.up.as.entidade.Venda;

public class FactoryDao {
	
	public static Dao<Cliente> createClienteDao() {
		return new ClienteDao();
	}
	
	public static Dao<Lanche> createLancheDao() {
		return new LancheDao();
	}
	
	public static Dao<Venda> createVendaDao() {
		return new VendaDao();
	}
}
