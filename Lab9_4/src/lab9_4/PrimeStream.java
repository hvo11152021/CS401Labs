package lab9_4;

import java.util.stream.Stream;

public class PrimeStream {
    
    private static int nextPrime(int num) {
        int next = num + 1;
        while (checkPrime(next) == false) {
            next++;
        }
        return next;
    }
    
    private static boolean checkPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
            	return false;
            }
        }
        return true;
    }
    
    public static void printFirstNPrimes(long n) {
    	// try with resources will close the stream to handle
    	//the use of more than once instance of this method
    	try (Stream<Integer> primeStream = Stream.iterate(2, PrimeStream::nextPrime)){
    		primeStream.limit(n).forEach(System.out::println);
    	}
    }
    
    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream();
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}

