package lab8_4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Main {
	/* As a lambda:
	 * public static void main(String[] args) { BiFunction<Integer, Integer,
	 * Integer> f = (x,y) -> 2*x - y; System.out.println(f.apply(2, 3)); }
	 */
	public static void main(String[] args) {
		class MyBiFunction implements BiFunction<Double, Double, List<Double>> {
			List<Double> list = new ArrayList<>();
			public List<Double> apply(Double x, Double y) {
			    list.add(Math.pow(x,y));
			    list.add(x * y);
				return list;
			}
		}
		MyBiFunction f = new MyBiFunction();
		System.out.println(f.apply(2.0, 3.0));
	}

}
