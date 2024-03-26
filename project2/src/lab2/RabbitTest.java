package lab2;

public class RabbitTest {
	public static void main(String args[]) {
		RabbitModel model = new RabbitModel();
		// checking that population was initialized to 2
		System.out.println(model.getPopulation());
		System.out.println("Expect value: 2");
		
		// checking that simulate years increments population
		model.simulateYear();
		System.out.println(model.getPopulation());
		System.out.println("Expect value: 3");
		
		// testing reset function
		model.reset();
		System.out.println(model.getPopulation());
		System.out.println("Expect value: 2");
		
	}	
	
}
