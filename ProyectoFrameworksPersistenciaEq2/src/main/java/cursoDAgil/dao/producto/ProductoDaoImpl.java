package cursoDAgil.dao.producto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Marca;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.mappers.ProductoMapper;



@Named
public class ProductoDaoImpl implements ProductoDao, Serializable{
	private static final long serialVersionUID = -6456965766968902300L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		List<Producto> list = null;
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list = productoMapper.listarProducto();
			for(Producto c:list) {
				System.out.println("ID producto: "+ c.getIdProducto());
				System.out.println("Nombre producto: "+c.getNombre());
				System.out.println("Precio: "+c.getPrecio());
				System.out.println("Precio venta: "+c.getPrecioVta());
				System.out.println("Cantidad: "+c.getCantidad());
				System.out.println("marcaId: "+c.getMarcaId());
				System.out.println();
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	@Override
	public Integer altaProducto(Producto producto) {
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			return productoMapper.altaProducto(producto);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public Integer eliminarProducto(Integer idProducto) {
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			return productoMapper.eliminarProducto(idProducto);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public Integer actualizarProducto(Producto producto) {
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			return productoMapper.actualizarProducto(producto);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public Producto buscarPorId(Map<String, Integer> mapProducto) {
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			Producto producto = new Producto();
			producto = productoMapper.buscarPorId(mapProducto);
			System.out.println("ID producto: "+ producto.getIdProducto());
			System.out.println("Nombre producto: "+producto.getNombre());
			System.out.println("Precio: "+producto.getPrecio());
			System.out.println("Precio venta: "+producto.getPrecioVta());
			System.out.println("Cantidad: "+producto.getCantidad());
			System.out.println("marcaId: "+producto.getMarcaId());
			System.out.println();
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public Producto buscarPorIdconMarca(Map<String, Integer> mapProducto) {
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			Producto producto = new Producto();
			producto = productoMapper.buscarPorIdconMarca(mapProducto);
			System.out.println("ID producto: "+ producto.getIdProducto());
			System.out.println("Nombre producto: "+producto.getNombre());
			System.out.println("Precio: "+producto.getPrecio());
			System.out.println("Precio venta: "+producto.getPrecioVta());
			System.out.println("Cantidad: "+producto.getCantidad());
			System.out.println("marcaId: "+producto.getMarcaId());
			Marca marca = new Marca();
			marca = producto.getMarca();
			System.out.println("Datos de la marca del producto");
			System.out.println("Id de la marca: " + marca.getIdMarca());
			System.out.println("Nombre de la marca "+ marca.getNombreMarca());
			System.out.println();
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public List<Producto> listarProductosconMarca() {
		try{
			List<Producto> list = null;
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list = productoMapper.listarProductosconMarca();
			for(Producto p:list) {
				System.out.println("ID producto: "+ p.getIdProducto());
				System.out.println("Nombre producto: "+p.getNombre());
				System.out.println("Precio: "+p.getPrecio());
				System.out.println("Precio venta: "+p.getPrecioVta());
				System.out.println("Cantidad: "+p.getCantidad());
				System.out.println("marcaId: "+p.getMarcaId());
				Marca marca = new Marca();
				marca = p.getMarca();
				System.out.println("Datos de la marca del producto");
				System.out.println("Id de la marca: " + marca.getIdMarca());
				System.out.println("Nombre de la marca: "+ marca.getNombreMarca());
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	
}
