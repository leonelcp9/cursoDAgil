package cursoDAgil.service.producto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Producto;
import cursoDAgil.dao.producto.ProductoDao;

@Named
public class ProductoServiceImpl implements ProductoService, Serializable{
	private static final long serialVersionUID = -3636050252009531409L;
	@Inject
	
	ProductoDao productoDao;
	
	@Override
	public List<Producto> listarProducto(){
		return productoDao.listarProducto();
	}

	@Override
	public Integer altaProducto(Producto producto) {
		return productoDao.altaProducto(producto);
	}

	@Override
	public Integer eliminarProducto(Integer idProducto) {
		return productoDao.eliminarProducto(idProducto);
	}

	@Override
	public Integer actualizarProducto(Producto producto) {
		return productoDao.actualizarProducto(producto);
	}

	@Override
	public Producto buscarPorId(Map<String, Integer> mapProducto) {
		return productoDao.buscarPorId(mapProducto);
	}
}