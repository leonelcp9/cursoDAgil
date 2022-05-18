package cursoDAgil.service.cliente;

import java.util.List;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteService {
	List<Cliente> listarTodosClientes();
	Integer nuevoCliente(Cliente cliente);
	Cliente obtenerClientePorId(int id);
	Integer eliminarClientePorId(Integer idcliente);
	Integer actualizarClientePorID(Cliente cliente);
	Cliente obtenerSoloClientePorId(int id);
	List<Cliente> listarTodosSoloClientes();

}
