package lesson9.labs.prob1.business;

import java.util.*;
import java.util.stream.Collectors;

import lesson9.labs.prob1.dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingAtLeastTwoCopies());
		System.out.println(allHavingMultipleAuthors());

	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		return new DataAccessFacade().readMemberMap().values().stream()
				.filter(m -> m.getAddress().getZip().contains("3"))
				.map(LibraryMember::getMemberId)
				.collect(Collectors.toList());
		
	}
	//Returns a list of all isbns of books having at least two copies
	public static List<String> allHavingAtLeastTwoCopies() {
		return new DataAccessFacade().readBooksMap().values().stream()
				.filter(b -> b.getCopies().length>=2)
				.map(Book::getIsbn)
				.collect(Collectors.toList());
		
	}

	//Returns a list of all isbns of Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		//implement
		return new DataAccessFacade().readBooksMap().values().stream()
				.filter(b -> b.getAuthors().size()>1)
				.map(Book::getIsbn)
				.collect(Collectors.toList());
		
	}

}
