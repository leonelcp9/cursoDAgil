//////////////////////////////////
/* Equipo 2							*/
/* Autor: Mendez Gonzalez William	*/
/* Fecha: 27/04/2022				*/
/////////////////////////////////// 
package cursoDAgil.dao.cliente;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.ClienteMapper;

@Named
public class ClienteDaoImpl implements ClienteDao, Serializable {

	private static final long serialVersionUID = -6456965766968902300L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<Cliente> listarTodosClientes(){
		List<Cliente> list =null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list=clienteMapper.listarTodosClientes();
			for(Cliente c:list) {
				System.out.println("Id: "+ c.getId());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Direccion"+ c.getDireccion().getCalle());
			}
			return list;
		}catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public Integer nuevoCliente(Cliente cliente) {
		try{
			ClienteMapper clienteMapper =
					sqlSession.getMapper(ClienteMapper.class);
	
			System.out.println("Cliente creada con �xito");
			return clienteMapper.nuevoCliente(cliente);
		}catch (Exception e) {
		System.out.println("Error: " + e);
		}
		return null;
	}
	public Cliente obtenerClientePorId(int id) {
		Cliente cliente = null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			cliente = clienteMapper.obtenerClientePorId(id);
			System.out.println("El cliente obtenido es:");
			System.out.println("Id: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			Direccion cdir = cliente.getDireccion();
			System.out.println("Direccion: " + cdir.getCalle() + ", " + cdir.getNumero() + ", "  + cdir.getColonia() + ", " + cdir.getCiudad() + ", " +  cdir.getCodigoPostal() + ", " + cdir.getEstado());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cliente;
	}
	@Override
	public Integer eliminarClientePorId(Integer idcliente) {
		try {
			ClienteMapper clientemapper=sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente Eliminado");
			return clientemapper.eliminarClientePorId(idcliente);
		}catch(Exception e) {
			System.out.println("Error"+ e);
		}
		return null;
	}
	@Override
	public Integer actualizarClientePorID(Cliente cliente) {
		try{
			ClienteMapper clientemapper=sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente Actualizado con Exito");
			return clientemapper.actualizarClientePorID(cliente);
		}catch(Exception e) {
			System.out.println("Error "+e);
		}
		return null;
	}
	@Override
	public List<Cliente> listarTodosSoloClientes(){
		List<Cliente> list =null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list=clienteMapper.listarTodosClientes();
			for(Cliente c:list) {
				System.out.println("Id: "+ c.getId());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Direccion"+ c.getDireccion().getCalle());
			}
			return list;
		}catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public Cliente obtenerSoloClientePorId(int id) {
		Cliente cliente = null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			cliente = clienteMapper.obtenerClientePorId(id);
			System.out.println("El cliente obtenido es:");
			System.out.println("Id: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			Direccion cdir = cliente.getDireccion();
			System.out.println("Direccion: " + cdir.getCalle() + ", " + cdir.getNumero() + ", "  + cdir.getColonia() + ", " + cdir.getCiudad() + ", " +  cdir.getCodigoPostal() + ", " + cdir.getEstado());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cliente;
	}
}
