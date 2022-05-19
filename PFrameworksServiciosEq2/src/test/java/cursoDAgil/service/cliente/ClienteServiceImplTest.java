//////////////////////////////////
/* Equipo 2							*/
/* Autor: Mendez Gonzalez William	*/
/* Fecha: 18/05/2022				*/
/////////////////////////////////// 
package cursoDAgil.service.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ClienteServiceImplTest {
	@Inject
	ClienteService clienteService;
	
	@Test
	public void pruebaConsultarTodo() {
		try {
			List<Cliente> lista = clienteService.listarTodosClientes();
			int size = lista.size();
			assertEquals(lista.size(),size);
		}catch(Exception e) {
			System.out.println("error "+e);
		}
	}
	
	@Test
	public void pruebaConsultarTodoSoloCliente() {
		int reg;
		System.out.println("Test consultar todas los clientes");
	
		try{
			List<Cliente> lista = clienteService.listarTodosClientes();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	
	@Test
	public void consultarClientePorId(){
		System.out.println("Test para obtener un cliente por Id");
		try {
			Cliente cliente = clienteService.obtenerClientePorId(1);
			assertNotNull(cliente);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	@Test
	public void consultarSoloClientePorId(){
		System.out.println("Test para obtener un cliente por Id");
		try {
			Cliente cliente = clienteService.obtenerClientePorId(1);
			assertNotNull(cliente);
		} catch (Exception e) {
			System.out.println("error: " + e);
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
			clienteService.nuevoCliente(cliente);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void eliminarcliente() {
		System.out.println("Test eliminar Direccion");
		try {
			clienteService.eliminarClientePorId(4);
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
			clienteService.actualizarClientePorID(cliente);
		}catch(Exception e) {
			System.out.println("Error"+e);
		}
	}
}
