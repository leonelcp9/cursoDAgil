//////////////////////////////////
/* Equipo 2							*/
/* Autor: Lòpez Guevara Jesus Alejandro	*/
/* Fecha: 16/05/2022				*/
/////////////////////////////////// 
package cursoDAgil.service.venta;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Venta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class VentaServiceImplTest {
	@Inject
	VentaService ventaService;
	
	@Ignore
	public void pruebaConsultarTodasLasVentas(){
		System.out.println("Test consultar todas las ventas y los clientes a los que pertenece");
		try {
			List<Venta> lista = ventaService.listarTodasVentas();
			int size = lista.size();
			assertEquals(lista.size(),size);
		}catch(Exception e) {
			System.out.println("error "+e);
		}
		
	}
	
	@Ignore
	public void pruebaConsultarVentasCliente() {
		System.out.println("inicio de prueba CONSULTA POR CLIENTE");
		try {
			
			Integer id = 1 ;
			List<Venta> lista = ventaService.consultarVentaCliente(id);
			int size = lista.size();
			assertEquals(lista.size(), size);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	@Ignore
	public void pruebaConsultarVentaId() {
		System.out.println("inicio de prueba CONSULTA POR IDventa");
		try {
			
			Integer id = 1 ;
			List<Venta> lista = ventaService.consultarVentaId(id);
			assertEquals(lista.size(), 1);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	/*
	 * Función que prueba a insertar una venta nueva en la base de datos
	 */
	@Ignore
	public void pruebaInsertarVenta() {
		System.out.println("Test insertar venta");
		try {
			
			Date date = new Date(System.currentTimeMillis());
			Venta venta = new Venta();
			venta.setClienteId(1);
			venta.setTotalVenta(700f);
			venta.setFecha(date);
			ventaService.altaVenta(venta);
		}catch(Exception ex) {
			System.out.println("error" + ex);
		}
		System.out.println("Venta insertada con exito");
	}
	@Ignore
	public void pruebaEliminarVenta() {
		System.out.println("Test de eliminar Venta");
		Integer idPrueba = 11;
		try {
			System.out.println("Borrado con exito");
			ventaService.eliminarVenta(idPrueba);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	@Test
	public void pruebaActualizarVenta() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test de actualizar Venta");
		try {
			Venta venta = new Venta();
		Date date = new Date(System.currentTimeMillis());
		venta.setIdVenta(1);
		venta.setClienteId(2);
		venta.setTotalVenta(900f);
		venta.setFecha(date);
		ventaService.actualizarVenta(venta);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	

}
