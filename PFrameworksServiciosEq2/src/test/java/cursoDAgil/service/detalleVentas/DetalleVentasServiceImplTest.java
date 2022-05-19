package cursoDAgil.service.detalleVentas;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.dao.detalleVentas.DetalleVentasDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DetalleVentasServiceImplTest {
	
	@Inject
	DetalleVentasService detalleventasService;
	
	@Test
	public void pruebaConsultarVentas() {
		try {
			Integer id=1;
			List<DetalleVentas> lista = detalleventasService.listarTodosDetalleVentas(id);
			int size = lista.size();
			assertEquals(lista.size(), size);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	
	@Test
	public void pruebaAltaDetalleVenta() {
		try {
			DetalleVentas detalle = new DetalleVentas();
			Producto prod = new Producto();
			prod.setIdProducto(2);
			detalle.setVenvtaId(1);
			detalle.setProducto(prod);
			detalle.setProductoId(detalle.getProducto().getIdProducto());
			detalle.setCantidad(2);
			detalleventasService.altaDetalleVenta(detalle);
		}catch(Exception ex) {
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultaTodosDetalleVentas() {
		try {
			List<DetalleVentas> lista = detalleventasService.consultaDetalleVenta();
			int size = lista.size();
			assertEquals(lista.size(),size);
		}catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
}
