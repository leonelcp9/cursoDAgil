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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.dao.detalleVentas.DetalleVentasDao;


	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = {"/applicationContext.xml"})
	public class DetalleVentasDaoImplTest {
		@Inject
		DetalleVentasDao detalleventasDao;
		
		@Test
		public void pruebaConsultarVentas() {
			System.out.println("Test consultar todas los detalles de ventas y los productos");
			try {
				Integer id=1;
				List<DetalleVentas> lista = detalleventasDao.listarTodosDetalleVentas(id);
				int size = lista.size();
				assertEquals(lista.size(), size);
			} catch (Exception ex) {
				System.out.println("error" + ex);
			}
		}
		
		@Test
		public void pruebaAltaDetalleVenta() {
			System.out.println("Test insertar detalle Venta");
			try {
				DetalleVentas detalle = new DetalleVentas();
				Producto prod = new Producto();
				prod.setIdProducto(2);
				detalle.setVenvtaId(1);
				detalle.setProducto(prod);
				detalle.setProductoId(detalle.getProducto().getIdProducto());
				detalle.setCantidad(2);
				detalleventasDao.altaDetalleVenta(detalle);
			}catch(Exception ex) {
				System.out.println("error" + ex);
			}
		}
		@Test
		public void pruebaConsultaTodosDetalleVentas() {
			System.out.println("Prueba consultar todos los detalles de Venta");
			try {
				List<DetalleVentas> lista = detalleventasDao.consultaDetalleVenta();
				int size = lista.size();
				assertEquals(lista.size(),size);
			}catch (Exception ex) {
				System.out.println("error" + ex);
			}
		}
	}

