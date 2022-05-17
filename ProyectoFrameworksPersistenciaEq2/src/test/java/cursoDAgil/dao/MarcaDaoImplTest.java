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
import cursoDAgil.bd.domain.Marca;
import cursoDAgil.dao.marca.MarcaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class MarcaDaoImplTest {
	@Inject
	MarcaDao marcaDao;
	@Test
	
	public void pruebaConsultarTodo(){
		System.out.println("Test consultar todas las marcas");
		try{
			System.out.println("");
			System.out.println("✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺");
			List<Marca> lista = marcaDao.listarMarcas();
			int a =lista.size();
			assertEquals(lista.size(),a);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	
	@Test
	public void eliminarMarca() {
		try{
			marcaDao.eliminarMarca(2);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("Marca eliminada");
	}
	
	@Test
	public void actualizarMarca() {
		Marca nombreMarca = new Marca();
		try{
			nombreMarca.setIdMarca(3);;
			nombreMarca.setNombreMarca("Gamesa");
			marcaDao.actualizarMarca(nombreMarca);
		}catch (Exception e) {
			System.out.println("Error: " + e);
	}
		System.out.println("Marca actualizada");
  }	
	
	@Test
	public void nuevaMarca(){
		Marca nombreMarca= new Marca();
		try{
			nombreMarca.setNombreMarca("Gamesa");
			nombreMarca.setIdMarca(3);
			marcaDao.nuevaMarca(nombreMarca);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Test
	public void consultarMarcaPorId(){
		Marca marca = new Marca();
		Map<String, Integer> mapMarca = new HashMap<>();
		mapMarca.put("idMarca",3);
		try{
			marca=marcaDao.obtenerMarcaporId(mapMarca);
			assertNotNull(marca);
			System.out.println("Nombre:" + marca.getNombreMarca());
			System.out.println("Id:" + marca.getIdMarca());
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
}