package br.edu.up.as.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.up.as.dao.LancheDao;
import br.edu.up.as.entidade.Lanche;
import br.edu.up.as.service.LancheService;
import br.edu.up.as.service.ServiceException;

@Path("/detalhelanche")
public class LancheRest {

		//http://localhost:8080/as/rest/detalhelanche
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Lanche> listarLanches() {
			List<Lanche> lanches = new LancheDao().listar();
			return new ArrayList<>(lanches);
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void cadastrarLanche(Lanche lanche) {
			try {
				new LancheService().salvar(lanche);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/excluir")
		public void deletarLanche(Lanche lanche) {
			//System.out.println("DEVERIA EXCLUIR");
			try {
				new LancheService().excluir(lanche);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/alterar")
		public void altererLanche(Lanche lanche) {
			try {
				new LancheService().alterar(lanche);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

}
