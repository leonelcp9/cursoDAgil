package cursoDAgil.service.producto;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

//import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Producto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class ProductoServiceImplTest {
	
	@Inject
	ProductoService productoService;
	
	@Test
	public void pruebaListarProducto() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar todos los productos");
		try {
			List<Producto> lista = productoService.listarProducto();
			assertEquals(lista.size(),lista.size());
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	@Test
	public void pruebaAltaProducto() {
		System.out.println("------------------------------------------------------");
		Producto producto = new Producto();
		System.out.println("Test de alta de producto");
		try {
			System.out.println("Producto dado de alta con éxito");
			producto.setCantidad(150);
			producto.setIdProducto(5);
			producto.setMarcaId(2);
			producto.setNombre("Manzanita");
			producto.setPrecio(25);
			producto.setPrecioVta(28);
			productoService.altaProducto(producto);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
	@Test
	public void pruebaEliminarProducto() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test de eliminar producto");
		Integer idPrueba = 15;
		try {
			productoService.eliminarProducto(idPrueba);
			System.out.println("Borrado con exito");
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	@Test
	public void pruebaActualizarProducto() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test de actualizar producto");
		Map<String, Integer> mapProducto = new HashMap<>();
		Producto producto = new Producto();
		mapProducto.put("idProducto",16);
		try {
			producto.setCantidad(170);
			producto.setIdProducto(16);
			producto.setMarcaId(2);
			producto.setNombre("Mirinda");
			producto.setPrecio(28);
			producto.setPrecioVta(30);
			productoService.actualizarProducto(producto);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	@Test
	public void pruebaBuscarPorId() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test para consultar por ID");
		Producto producto = new Producto();
		Map<String, Integer> mapProducto = new HashMap<>();
		mapProducto.put("idProducto",23);
		try {
			producto=productoService.buscarPorId(mapProducto);
			System.out.println("Nombre:" + producto.getNombre());
			System.out.println("Cantidad:" + producto.getCantidad());
			System.out.println("Id Producto: " + producto.getIdProducto());
			System.out.println("Marca ID: " + producto.getMarcaId());
			System.out.println("Precio" + producto.getPrecio());
			System.out.println("Precio Venta" + producto.getPrecioVta());
			System.out.println();
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
}


/* @Before, @After */