package ssafy0819.com.a;

public class Airplane extends Vehicle {
	public Airplane() {
		System.out.println("A");
	}
	public Airplane(String name) {
		this();
		System.out.println("T");
	}
	public void print() {
		System.out.println("Airplane");
	}
	public void sayAirplane(String name) {
		System.out.println(name);
	}
}
