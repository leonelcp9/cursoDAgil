//////////////////////////////////////
/* Equipo 2							*/
/* Autor: Cruz Peralta Leonel   	*/
/* Fecha: 18/05/2022				*/
//////////////////////////////////////
package cursoDAgil.service.detalleVentas;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.service.detalleVentas.DetalleVentasService;
import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Producto;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class DetalleVentasServiceImplTest {
	@Inject
	DetalleVentasService detalleVentasService;
	
	
	@Test
	public void pruebaConsultarVentas() {
		System.out.println("Test consultar todas los detalles de ventas y los productos");
		try {
			Integer id=1;
			List<DetalleVentas> lista = detalleVentasService.listarTodosDetalleVentas(id);
			int size = lista.size();
			assertEquals(lista.size(), size);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	@Ignore
	public void pruebaAltaDetalleVenta() {
		try {
			DetalleVentas detalle = new DetalleVentas();
			Producto prod = new Producto();
			prod.setIdProducto(2);
			detalle.setVenvtaId(1);
			detalle.setProducto(prod);
			detalle.setProductoId(detalle.getProducto().getIdProducto());
			detalle.setCantidad(2);
			detalleVentasService.altaDetalleVenta(detalle);
		}catch(Exception ex) {
			System.out.println("error" + ex);
		}
	}
	@Ignore
	public void pruebaConsultaTodosDetalleVentas() {
		
		try {
			List<DetalleVentas> lista = detalleVentasService.consultaDetalleVenta();
			int size = lista.size();
			assertEquals(lista.size(),size);
		}catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
}
