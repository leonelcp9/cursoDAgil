package cursoDAgil.dao.ganancia;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Ganancia;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.domain.Venta;

public interface GananciaDao {
	List<Ganancia> listarGanancia();
	List<Ganancia> listarPorFecha(Map <String, String> mapGanancia);
	Integer crearGananciaDeVenta(Ganancia ganancia);
	Float calcularGanancia(List<Producto> productos);
}
