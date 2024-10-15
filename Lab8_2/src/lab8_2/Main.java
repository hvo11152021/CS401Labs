package lab8_2;

import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GetRandom.supplier.get());
	}
	
	class GetRandom {
		static Supplier<Double> supplier = () -> Math.random();
	}

}
