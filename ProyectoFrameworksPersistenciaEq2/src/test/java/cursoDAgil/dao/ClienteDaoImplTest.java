//////////////////////////////////
/* Equipo 2							*/
/* Autor: Mendez Gonzalez William	*/
/* Fecha: 28/04/2022				*/
/////////////////////////////////// 
package cursoDAgil.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.dao.cliente.ClienteDao;
import cursoDAgil.dao.direccion.DireccionDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class ClienteDaoImplTest {
	
	@Inject
	ClienteDao clienteDao;
	DireccionDao direccionDao;
	
	@Test
	public void consultarClientePorId(){
		System.out.println("Test para obtener un cliente por Id");
		try {
			Cliente cliente = clienteDao.obtenerClientePorId(1);
			assertNotNull(cliente);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas los clientes");
	
		try{
			List<Cliente> lista = clienteDao.listarTodosClientes();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	
	@Test
	public void nuevoRegistro(){
		
		//Direccion direccion = consultarDireccionPorId(1);
		Cliente cliente= new Cliente();
		System.out.println("Test nuevo registro");
		try{
			cliente.setNombre("Test");
			cliente.setApellido("asdasd");
			cliente.setEmail("asdas@gmail.com");
			cliente.setSexo("femenino");
			cliente.setIddireccion(1);
			clienteDao.nuevoCliente(cliente);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void eliminarcliente() {
		System.out.println("Test eliminar Direccion");
		try {
			clienteDao.eliminarClientePorId(3);
		}catch(Exception e){
			System.out.println("Error"+ e );
		}
	}
	@Test
	public void actualizarCliente() {
				
		Cliente cliente= new Cliente();
		System.out.println("Test Actualizar Direccion");
		try {
			cliente.setNombre("Actualizado");
			cliente.setApellido("asdasd");
			cliente.setEmail("asdas@gmail.com");
			cliente.setIddireccion(1);
			cliente.setSexo("Masculino");
			cliente.setId(3);
			clienteDao.actualizarClientePorID(cliente);
		}catch(Exception e) {
			System.out.println("Error"+e);
		}
	}

}
