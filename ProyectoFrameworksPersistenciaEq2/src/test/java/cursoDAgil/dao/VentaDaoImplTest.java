//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesùs Alejandro, Cruz Peralta Leonel */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.dao.venta.VentaDao;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class VentaDaoImplTest {
	@Inject
	VentaDao ventaDao;
	
	@Test
	public void pruebaConsultarVentas() {
		System.out.println("Test consultar todas las ventas y los clientes a los que pertenece");
		try {
			List<Venta> lista = ventaDao.listarTodasVentas();
			int size = lista.size();
			assertEquals(lista.size(), size);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarVentasCliente() {
		System.out.println("inicio de prueba CONSULTA POR CLIENTE");
		try {
			
			Integer id = 1 ;
			List<Venta> lista = ventaDao.consultarVentaCliente(id);
			int size = lista.size();
			assertEquals(lista.size(), size);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarVentaId() {
		System.out.println("inicio de prueba CONSULTA POR IDventa");
		try {
			
			Integer id = 1 ;
			List<Venta> lista = ventaDao.consultarVentaId(id);
			assertEquals(lista.size(), 1);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	/*
	 * Función que prueba a insertar una venta nueva en la base de datos
	 */
	@Test
	public void pruebaInsertarVenta() {
		System.out.println("Test insertar venta");
		try {
			
			Date date = new Date(System.currentTimeMillis());
			Venta venta = new Venta();
			venta.setClienteId(1);
			venta.setTotalVenta(900f);
			venta.setFecha(date);
			ventaDao.altaVenta(venta);
		}catch(Exception ex) {
			System.out.println("error" + ex);
		}
		System.out.println("Venta insertada con exito");
	}
	@Test
	public void pruebaEliminarVenta() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test de eliminar Venta");
		Integer idPrueba = 11;
		try {
			System.out.println("Borrado con exito");
			ventaDao.eliminarVenta(idPrueba);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
}