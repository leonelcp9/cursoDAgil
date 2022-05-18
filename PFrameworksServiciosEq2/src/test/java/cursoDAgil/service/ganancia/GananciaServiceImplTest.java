package cursoDAgil.service.ganancia;

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

import cursoDAgil.bd.domain.Ganancia;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class GananciaServiceImplTest {

	@Inject
	GananciaService gananciaService;
	
	@Test
	public void pruebaListarGanancia() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar todas las ganancias");
		try {			
			List<Ganancia> lista = gananciaService.listarGanancia();
			//int a = lista.size();
			//assertEquals(lista.size(),a);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	@Test
	public void pruebaListarPorFecha() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar por fecha");
		Map<String, String> mapGanancia = new HashMap<>();
		mapGanancia.put("fecha","2022-04-23");
		try {
			List <Ganancia> lista = gananciaService.listarPorFecha(mapGanancia);
			//int a = lista.size();
			//assertEquals(lista.size(),a);
			}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	@Test
	public void pruebaAltaGanancia() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test alta de ganancia");
		Ganancia ganancia = new Ganancia();
		try {
			float total = 2500;
			ganancia.setFecha("2022-05-20");
			ganancia.setIdGanancia(1);
			ganancia.setTotalGanancia(total);
			ganancia.setVentaId(1);
			gananciaService.altaGanancia(ganancia);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
}








