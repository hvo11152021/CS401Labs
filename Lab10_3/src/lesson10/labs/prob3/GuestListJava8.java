package lesson10.labs.prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GuestListJava8 {
	 
	public static void main(String[] args) {
		final boolean yes = true;
		final boolean no = false;
		GuestListJava8 gl = new GuestListJava8();
		List<Guest> invited 
		  = Arrays.asList(new Guest("Joe Stevens", Status.COMMON, Gender.M, 5, yes),
				          new Guest("Susan Richards", Status.GOLD, Gender.F, 10, no),
				          new Guest("Toni Smith", Status.COMMON, Gender.F, 4, yes),
				          new Guest("Anthony Hawkins", Status.ILLEGAL, Gender.M, 0, yes),
				          new Guest("Tony Thomas", Status.SILVER, Gender.M, 8, no),
				          new Guest("Antoinette Cerisier", Status.SILVER, Gender.F, 7, yes),
				          new Guest("Ricardo Salhuega", Status.COMMON, Gender.M, 2, yes));
		
		gl.printListOfExpectedFemaleGuests(invited);
		
	}
	private boolean checkLegal(Guest g) throws IllegalGuestException {
		boolean isIllegal = (g.getStatus() == Status.ILLEGAL);
		if(isIllegal) throw new IllegalGuestException(String.format(
					"Illegal guest %s has attempted entry to the event", g.getName()));
		else return true;
	}
	
	public void printListOfExpectedFemaleGuests(List<Guest> invited) {
		String guests = (invited.stream()
				.filter(g -> {
	                try {
	                    return checkLegal(g);
	                } catch (Exception e) {
	                    System.out.println(e.getMessage());
	                    return false;
	                }
	            })
				// or .filter(g -> PredicateWithException.unchecked((Guest p) -> checkLegal(p)).test(g))
				.filter(g -> g.getGender() == Gender.F && g.isPlanningToCome())
				.sorted((g,h) -> g.getName().compareTo(h.getName()))
				.map(Guest::toString)
				.collect(Collectors.toList()).toString());
		System.out.println(guests);
	}
	
	
	class IllegalGuestException extends Exception {
		private static final long serialVersionUID = 1L;
		IllegalGuestException() {
			super("An illegal guest has attempted entry.");
		}
		IllegalGuestException(String msg) {
			super(msg);
		}
		IllegalGuestException(Throwable t) {
			super(t);
		}
	}
}
