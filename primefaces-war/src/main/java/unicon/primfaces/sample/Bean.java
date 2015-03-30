package unicon.primfaces.sample;

import javax.faces.bean.ViewScoped;
import javax.inject.Named; 

@ViewScoped
@Named
public class Bean {
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
