//////////////////////////////////////////////
/* Equipo 2									*/
/* Autor: Guerrero Hernández Samuel Antonio	*/
/* Fecha: 20/05/2022						*/
////////////////////////////////////////////// 
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
	
	public List<Producto> listarProducto(){
		return productoDao.listarProducto();
	}

	public Integer altaProducto(Producto producto) {
		return productoDao.altaProducto(producto);
	}

	public Integer eliminarProducto(Integer idProducto) {
		return productoDao.eliminarProducto(idProducto);
	}

	public Integer actualizarProducto(Producto producto) {
		return productoDao.actualizarProducto(producto);
	}

	public Producto buscarPorId(Map<String, Integer> mapProducto) {
		return productoDao.buscarPorId(mapProducto);
	}

	public Producto buscarPorIdconMarca(Map<String, Integer> mapProducto) {
		return productoDao.buscarPorIdconMarca(mapProducto);
	}

	public List<Producto> listarProductosconMarca() {
		return productoDao.listarProductosconMarca();
	}
}