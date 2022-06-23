/***************************************/
/* Equipo 2 						   */
/* Guerrero Hernández Samuel Antonio l */
/* 23/06/22                             */
/***************************************/

package cursoDAgil.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.service.Marca.MarcaService;

import cursoDAgil.bd.domain.Marca;
@Named

public class MarcaConverter implements Converter {
	@Inject
	MarcaService marcaService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value){
		if(value != null && (value.trim().length()>0)){
			try{
				Map<String,Integer>mapMarca =new HashMap<>();
				mapMarca.put("idMarca", Integer.parseInt(value));
				Marca marca = marcaService.obtenerMarcaporId(mapMarca);
				System.out.println("Nombre marca: " + marca.getNombreMarca());
				return marca ;
			}catch(NumberFormatException e){
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value){
		if(((value !=null)&& ((Marca)value).getIdMarca()!=null)){
			return ((Marca)value).getIdMarca().toString();
		}else
			return null;
	}
}
