package ssafy0819.com.a;

public class VehicleTest1 {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		v.print();
		v.sayVehicle("hello " + v.getClass() + "\n");
		
		Vehicle a = new Airplane();
		a.print();			// -> Airplane Overriding
		a.sayVehicle("hello " + a.getClass() + "\n");
		
		/**
		 * 시험 문제 !!
		 * 	ex) a.print() 호출시 출력되는 것은?
		 */
		
		Airplane a2 = (Airplane)a;
		a2.print();
		a2.sayAirplane("me " + a2.getClass() +"\n");
		
		Airplane a3 = new Airplane();
		a3.print();
		a3.sayVehicle("hello " + a3.getClass() + "\n");
		
		
	}
}
