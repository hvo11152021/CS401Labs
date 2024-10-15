package lab8_6;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", "Away", "On Vacation", "Everywhere you want to be");
		list.forEach(s -> System.out.println(s.toUpperCase())); //case 1
		System.out.println("");
		list.stream().map(String::toUpperCase).forEach(System.out::println); //case 2
	}
}