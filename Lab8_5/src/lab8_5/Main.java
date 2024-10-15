package lab8_5;

import java.util.Arrays;
import java.util.List;

class People {
	public static final List<String> names = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Nora", "Scott");
}

public class Main {

	public static void main(String[] args) {
		System.out.println((new Main()).countWords(People.names, 'e', 'u', 4) + " words");
	}
	
	public int countWords(List<String> words, char c, char d, int len) {
		return (int) words.stream()
				.filter(w -> w.length()==len)
				.filter(w -> w.contains(c+""))
				.filter(w -> !w.contains(d+""))
				.count();
	}
	
}
