package cursoDAgil.managedBean.detalleVenta;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.context.PrimeFacesContext;

@Named("dfView")
@RequestScoped
public class DFView {
	public void verDetalle() {
		Map<String,Object> options = new HashMap<>();
		options.put("resizable", false);
		PrimeFaces.current().dialog().openDynamic("verDetalle",options,null);
	}
}
