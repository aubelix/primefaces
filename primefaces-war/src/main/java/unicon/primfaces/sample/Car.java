package unicon.primfaces.sample;

public class Car {
	
	String id;
	int year;

	public Car(String id, int year) {
		super();
		this.id = id;
		this.year = year;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
