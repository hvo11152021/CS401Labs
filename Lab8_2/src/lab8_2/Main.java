package lab8_2;

import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		Main instance = new Main();
		GetRandom rand = instance.new GetRandom();
		System.out.println(rand.get());
	}
	
	class GetRandom implements Supplier<Double>{
		@Override
		public Double get() {
			return Math.random();
		}
	}

}
