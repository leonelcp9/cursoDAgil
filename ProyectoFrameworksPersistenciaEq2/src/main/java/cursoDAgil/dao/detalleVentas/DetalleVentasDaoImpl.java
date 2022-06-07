//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesùs Alejandro, Cruz Peralta Leonel */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.dao.detalleVentas;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.bd.mappers.DetalleVentasMapper;
import cursoDAgil.bd.mappers.VentaMapper;
import cursoDAgil.dao.venta.VentaDao;

@Named
public class DetalleVentasDaoImpl implements DetalleVentasDao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<DetalleVentas> listarTodosDetalleVentas(Integer id) {
		List<DetalleVentas> list = null;
		try {
			DetalleVentasMapper detalleVentasMapper = sqlSession.getMapper(DetalleVentasMapper.class);
			list = detalleVentasMapper.listarTodosDetalleVentas(id);
			System.out.println("Tamaño de lista= "+list.size());
			for(DetalleVentas ven:list) {
				System.out.println("ventaId: "+ ven.getVenvtaId());
				System.out.println("Producto(idProduto): "+ ven.getProducto().getIdProducto());
				System.out.println("Producto(nombre): "+ ven.getProducto().getNombre());
				System.out.println("Producto(precio): "+ ven.getProducto().getPrecio());
				System.out.println("Producto(precioVta): "+ ven.getProducto().getPrecioVta());
				System.out.println("Producto(cantidad): "+ ven.getProducto().getCantidad());
				System.out.println("Producto(marcaId): "+ ven.getProducto().getMarcaId());
				System.out.println();
			}
			return list;
		}catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	public Integer altaDetalleVenta(DetalleVentas detalle) {
		try {
			DetalleVentasMapper detalleMapper = sqlSession.getMapper(DetalleVentasMapper.class);
			System.out.println("Detalle de venta creada con exito");
			return detalleMapper.altaDetalleVenta(detalle);
		}catch(Exception e) {
			System.out.println("Error"+e);
		}
		return null;
	}
	public List<DetalleVentas> consultaDetalleVenta() {
		List<DetalleVentas> detalle = null;
		try {
			DetalleVentasMapper detalleMapper = sqlSession.getMapper(DetalleVentasMapper.class);
			detalle = detalleMapper.consultaDetalleVenta();
			for(DetalleVentas aux : detalle) {
				System.out.println("idVenta: "+aux.getVenvtaId());
				System.out.println("idProducto: "+aux.getProductoId());
				System.out.println("Nombre del producto: "+aux.getProducto().getNombre());
				System.out.println("Cantidad: "+aux.getCantidad());
				System.out.println();
			}
			return detalle;
		}catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}
}
