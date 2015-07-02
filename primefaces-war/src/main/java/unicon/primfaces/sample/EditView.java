package unicon.primfaces.sample;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;

@Named
@javax.enterprise.context.SessionScoped
public class EditView implements Serializable {
     
    private List<Car> cars1;
    private List<Car> cars2;
    private String test ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
         
    @Inject
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars1 = service.createCars(100);
        cars2 = service.createCars(100);
    }
 
    public List<Car> getCars1() {
        return cars1;
    }
 
    public List<Car> getCars2() {
        return cars2;
    }
     
    public void setService(CarService service) {
        this.service = service;
    }     
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
     //       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
        //    FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

	public String getTest() {
		return String.valueOf(System.currentTimeMillis());
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	public void save(Car c, int index) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		RequestContext.getCurrentInstance().update("form:cars1:" + index + ":save");
	}
}