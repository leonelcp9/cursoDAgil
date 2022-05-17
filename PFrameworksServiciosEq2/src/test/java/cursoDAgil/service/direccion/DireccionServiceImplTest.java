//////////////////////////////////
/* Equipo 2							*/
/* Autor: Lòpez Guevara Jesus Alejandro	*/
/* Fecha: 16/05/2022				*/
/////////////////////////////////// 
package cursoDAgil.service.direccion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Direccion;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class DireccionServiceImplTest {
	
	@Inject
	DireccionService direccionService;
	
	@Test
	public void consultarDireccionPorId(){
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion",1);
		try{
			direccion=direccionService.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("id:" + direccion.getIddireccion());
			System.out.println("calle:" + direccion.getCalle());
			}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	@Test
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todas las direcciones");
	
		try{
			List<Direccion> lista = direccionService.obtenerDirecciones();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}

}
