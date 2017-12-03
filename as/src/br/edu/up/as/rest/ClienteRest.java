package br.edu.up.as.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.up.as.dao.ClienteDao;
import br.edu.up.as.entidade.Cliente;
import br.edu.up.as.service.ClienteService;
import br.edu.up.as.service.ServiceException;

@Path("/detalhecliente")
public class ClienteRest {

		//http://localhost:8080/as/rest/detalhecliente
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Cliente> listarClientes() {
			List<Cliente> clientes = new ClienteDao().listar();
			return new ArrayList<>(clientes);
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void cadastrarCliente(Cliente cliente) {
			try {
				new ClienteService().salvar(cliente);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/excluir")
		public void deletarCliente(Cliente cliente) {
			//System.out.println("DEVERIA EXCLUIR");
			try {
				new ClienteService().excluir(cliente);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/alterar")
		public void altererCliente(Cliente cliente) {
			try {
				new ClienteService().alterar(cliente);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

}
