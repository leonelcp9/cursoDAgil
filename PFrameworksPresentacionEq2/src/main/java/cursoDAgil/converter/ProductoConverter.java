/***************************************/
/* Equipo 2 						   */
/* Guerrero Hernández Samuel Antonio l */
/* 20/06/22                             */
/***************************************/

package cursoDAgil.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Producto;
import cursoDAgil.service.producto.ProductoService;

@Named
public class ProductoConverter implements Converter{
	@Inject
	ProductoService productoService;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && (value.trim().length() > 0)) {
			try {
				Map<String, Integer> mapProducto = new HashMap<>();
				mapProducto.put("idProducto",Integer.parseInt(value));
				return productoService.buscarPorId(mapProducto);
			} catch(NumberFormatException e) {
				return null;
			}
		}else {
			return null;
		}
	}
	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(((value != null) && ((Producto) value).getIdProducto().toString() !=null)) {
			return ((Producto) value).getIdProducto().toString();
		}
		else {
			return null;
		}
	}
	
	
}
