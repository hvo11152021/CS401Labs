package lesson9.labs.prob10a;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Or {

	public static void main(String[] args) {
		List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(true));
		System.out.println((new Or()).someSimpleIsTrue(list));
		
		Stream<String> stringStream = Stream.of("Bill, Thomas, Mary");
		System.out.println(stringStream.toList());
		
		Stream<Integer> myIntStream = Stream.generate(Math::random).limit(10).mapToInt(d -> (int) (d * 100)).boxed();
		IntSummaryStatistics summary = myIntStream.collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println("Max value: " + summary.getMax() + "\nMin value: " + summary.getMin());
	}
	
	public boolean someSimpleIsTrue(List<Simple> list) {
		return list.stream()
				.map(s -> s.flag)
				.reduce(false, (s, t) -> s || t);
	}

}
