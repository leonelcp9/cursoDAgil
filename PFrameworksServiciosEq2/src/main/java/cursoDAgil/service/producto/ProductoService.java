package cursoDAgil.service.producto;

import java.util.List;
import java.util.Map;



import cursoDAgil.bd.domain.Producto;

public interface ProductoService {
	List<Producto> listarProducto();
	Integer altaProducto(Producto producto);
	Integer eliminarProducto(Integer idProducto);
	Integer actualizarProducto(Producto producto);
	Producto buscarPorId(Map<String, Integer> mapProducto);
}
