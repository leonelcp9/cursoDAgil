//////////////////////////////////
/* Equipo 2							*/
/* Autor: Mendez Gonzalez William	*/
/* Fecha: 27/04/2022				*/
/////////////////////////////////// 
package cursoDAgil.dao.cliente;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteDao {
	List<Cliente> listarTodosClientes();
	Integer nuevoCliente(Cliente cliente);
	Cliente obtenerClientePorId(int id);
	Integer eliminarClientePorId(Integer idcliente);
	Integer actualizarClientePorID(Cliente cliente);
	Cliente obtenerSoloClientePorId(int id);
	List<Cliente> listarTodosSoloClientes();

}
