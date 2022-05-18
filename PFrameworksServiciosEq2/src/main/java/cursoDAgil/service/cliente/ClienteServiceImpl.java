package cursoDAgil.service.cliente;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;

@Named
public class ClienteServiceImpl implements ClienteService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7962397593863792875L;
	@Inject 
	ClienteDao clienteDao;
	
	public List<Cliente> listarTodosClientes(){
		return clienteDao.listarTodosClientes();
	}

	@Override
	public Integer nuevoCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.nuevoCliente(cliente);
	}

	@Override
	public Cliente obtenerClientePorId(int id) {
		// TODO Auto-generated method stub
		return clienteDao.obtenerClientePorId(id);
	}

	@Override
	public Integer eliminarClientePorId(Integer idcliente) {
		// TODO Auto-generated method stub
		return clienteDao.eliminarClientePorId(idcliente);
	}

	@Override
	public Integer actualizarClientePorID(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.actualizarClientePorID(cliente);
	}

	@Override
	public Cliente obtenerSoloClientePorId(int id) {
		// TODO Auto-generated method stub
		return clienteDao.obtenerSoloClientePorId(id);
	}

	@Override
	public List<Cliente> listarTodosSoloClientes() {
		// TODO Auto-generated method stub
		return clienteDao.listarTodosSoloClientes();
	}
}
