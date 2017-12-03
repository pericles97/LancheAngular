package br.edu.up.as.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.up.as.dao.VendaDao;
import br.edu.up.as.entidade.Venda;
import br.edu.up.as.service.ServiceException;
import br.edu.up.as.service.VendaService;

@Path("/detalhevenda")
public class VendaRest {

		//http://localhost:8080/as/rest/detalhevenda
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Venda> listarVendas() {
			List<Venda> vendas = new VendaDao().listar();
			return new ArrayList<>(vendas);
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void cadastrarVenda(Venda venda) {
			try {
				new VendaService().salvar(venda);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/excluir")
		public void deletarVenda(Venda venda) {
			//System.out.println("DEVERIA EXCLUIR");
			try {
				new VendaService().excluir(venda);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/alterar")
		public void altererVenda(Venda venda) {
			try {
				new VendaService().alterar(venda);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

}
