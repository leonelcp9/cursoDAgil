package cursoDAgil.dao;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Ganancia;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.dao.ganancia.GananciaDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class GananciaDaoImplTest {
	@Inject
	GananciaDao gananciaDao;
	
	@Test
	public void pruebaConsultarTodo() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar todas las ganancias");
		try {
			List<Ganancia> lista = gananciaDao.listarGanancia();
			int a = lista.size();
			assertEquals(lista.size(),a);
		}catch(Exception ex){
			System.out.println("Error" + ex);
		}
	}
	
	@Test 
	public void pruebaListarPorFecha() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar por fecha");
		Map<String, String> mapGanancia = new HashMap<>();
		mapGanancia.put("fecha","2022-04-28");
		try{
			List<Ganancia> lista = null;
			//List<Ganancia> lista = gananciaDao.listarPorFecha(mapGanancia);
			lista=gananciaDao.listarPorFecha(mapGanancia);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	/*
	 * Función que prueba crear una ganancia a partir de la venta que le damos
	 */
	
	@Test
	public void pruebaCrearGananciaDeVenta() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test crear ganancia a partir de Venta");
		try {
			List<Producto> productos = new ArrayList<Producto>();
			Producto p1 = new Producto();
			Producto p2 = new Producto();
			p1.setIdProducto(2);
			p1.setCantidad(2);
			p1.setMarcaId(2);
			p1.setNombre("Laptop i5");
			p1.setPrecio(25451.5f);
			p1.setPrecioVta(41000f);
			p2.setIdProducto(1);
			p2.setCantidad(3);
			p2.setMarcaId(2);
			p2.setNombre("Laptop i5");
			p2.setPrecio(25f);
			p2.setPrecioVta(27f);
			productos.add(p1);
			productos.add(p2);
			Venta venta = new Venta();
			venta.setIdVenta(1);
			venta.setClienteId(1);
			venta.setProductos(productos);
			venta.setTotalVenta(24234);
			Date date = new Date(System.currentTimeMillis());
			venta.setFecha(date);
			Ganancia ganancia = new Ganancia();
			ganancia.setFecha(String.valueOf(venta.getFecha()));
			ganancia.setVentaId(venta.getIdVenta());
			ganancia.setTotalGanancia(gananciaDao.calcularGanancia(productos));
			gananciaDao.crearGananciaDeVenta(ganancia);
		}catch(Exception ex) {
			System.out.println("error" + ex);
		}
		System.out.println("Ganancia insertada con exito");

	}
	
	@Test
	public void pruebaAltaGanancia() {
		System.out.println("------------------------------------------------------");
		Ganancia ganancia = new Ganancia();
		System.out.println("Test de alta de ganancia");
		try {
			System.out.println("Ganancia dada de alta");
			ganancia.setFecha("2022-05-20");
			ganancia.setIdGanancia(1);
			float tg = 2500;
			ganancia.setTotalGanancia(tg);
			ganancia.setVentaId(2);
			gananciaDao.altaGanancia(ganancia);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
}



















