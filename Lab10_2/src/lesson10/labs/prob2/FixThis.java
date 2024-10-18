package lesson10.labs.prob2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixThis {
	List<String> processList(List<String> list)  {
	   return list.stream()
	    		   .map(x -> FunctionWithException.unchecked((String p) -> doNothingIfShort(p)).apply(x))
	               .collect(Collectors.toList());
	}
	
	 
	String doNothingIfShort(String input) throws InputTooLongException {
	    if (input.length() > 3) throw new InputTooLongException();
	    else return input;
	}
	
	public static void main(String[] args) {
		FixThis ft = new FixThis();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet");
		List<String> words2 = Arrays.asList("currently", "too", "big");
		try {
            System.out.println(ft.processList(words1));
            System.out.println(ft.processList(words2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
	}
	
	class InputTooLongException extends Exception {
		private static final long serialVersionUID = 1L;
		public InputTooLongException() {
			super("Must be length 3 or less");
		}
		public InputTooLongException(String s) {
			super(s);
		}
		public InputTooLongException(Throwable t) {
			super(t);
		}
	}
}
