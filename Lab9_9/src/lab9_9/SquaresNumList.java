package lab9_9;

import java.util.stream.IntStream;

public class SquaresNumList {
	private static int toSquare = 1;
	private static Integer squareIt(Integer num) {
		return (++toSquare) * toSquare;
	}
	
	public static void printSquares(int num) {
		IntStream ints = IntStream.iterate(1, SquaresNumList::squareIt);
		ints.limit(num).boxed().forEach(System.out::println);;
	}

	public static void main(String[] args) {
		SquaresNumList.printSquares(4);
	}

}
