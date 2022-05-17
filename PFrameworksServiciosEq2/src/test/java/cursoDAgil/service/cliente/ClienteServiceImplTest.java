package cursoDAgil.service.cliente;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ClienteServiceImplTest {
	@Inject
	ClienteService clienteService;
	
	@Test
	public void pruebaConsultarTodo() {
		try {
			List<Cliente> lista = clienteService.listarTodosClientes();
			int size = lista.size();
			assertEquals(lista.size(),size);
		}catch(Exception e) {
			System.out.println("error "+e);
		}
	}
}
