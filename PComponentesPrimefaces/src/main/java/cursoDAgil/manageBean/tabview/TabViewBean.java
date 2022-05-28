package cursoDAgil.manageBean.tabview;

import java.io.Serializable;

public class TabViewBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3074524795990489638L;
	private boolean bandera;
	public boolean isBandera() {
		return bandera;
	}
	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TabViewBean(){
	setBandera(true);
	}
}
