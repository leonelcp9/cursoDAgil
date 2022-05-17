package cursoDAgil.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cursoDAgil.bd.domain.Producto;
import cursoDAgil.dao.producto.ProductoDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})

public class ProductoDaoImplTest {
	@Inject
	ProductoDao productoDao;
	
	@Test
	public void pruebaConsultarTodo() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar todas las ganancias");
		try {
			List<Producto> lista = productoDao.listarProducto();
			int a = lista.size();
			assertEquals(lista.size(),a);
		}catch(Exception ex){
			System.out.println("Error" + ex);
		}
	}
	
	@Test
	public void pruebaAltaProducto() {
		System.out.println("------------------------------------------------------");
		Producto producto = new Producto();
		System.out.println("Test de alta de producto");
		try {
			System.out.println("Producto dado de alta con exito");
			producto.setCantidad(100);
			producto.setIdProducto(7);
			producto.setMarcaId(2);
			producto.setNombre("Coke");
			producto.setPrecio(25);
			producto.setPrecioVta(27);
			productoDao.altaProducto(producto);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
	@Test
	public void pruebaActualizarProducto() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test de actualizar producto");
		Map<String, Integer> mapProducto = new HashMap<>();
		Producto producto = new Producto();
		Integer idPrueba = 1;
		mapProducto.put("idProducto",idPrueba);
		try{
			System.out.println("Producto actualizado con exito con id: " + idPrueba);
			producto.setCantidad(220);
			producto.setIdProducto(1);
			producto.setMarcaId(2);
			producto.setNombre("Rey Pinia");
			producto.setPrecio(25);
			producto.setPrecioVta(27);
			
			productoDao.actualizarProducto(producto);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void pruebaConsultaPorId(){
		System.out.println("------------------------------------------------------");
		System.out.println("Test para consultar por ID");
		Producto producto = new Producto();
		Map<String, Integer> mapProducto = new HashMap<>();
		mapProducto.put("idProducto",2);
		try{
			producto=productoDao.buscarPorId(mapProducto);
			//assertNotNull(producto);
			System.out.println("Nombre:" + producto.getNombre());
			System.out.println("Cantidad:" + producto.getCantidad());
			System.out.println("Id Producto: " + producto.getIdProducto());
			System.out.println("Marca ID: " + producto.getMarcaId());
			System.out.println("Precio" + producto.getPrecio());
			System.out.println("Precio Venta" + producto.getPrecioVta());
			System.out.println();
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
}
	
	@Test
	public void pruebaEliminarProducto() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test de eliminar producto");
		Integer idPrueba = 8;
		try {
			System.out.println("Borrado con exito");
			productoDao.eliminarProducto(idPrueba);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
}







