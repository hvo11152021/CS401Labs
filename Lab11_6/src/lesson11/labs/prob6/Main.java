package lesson11.labs.prob6;
import java.util.*;
import java.util.function.*;


public class Main {

    //simple version
	public static boolean contains1(List<String> list, String s) {
		for(String x: list) {
			if(x == null && s == null) return true;
			if(s == null || x == null) continue;
			if(x.equals(s)) return true;
		}
		return false;
	}
	
	public static <T> T secondSmallest(List<T> list, Comparator<? super T> compare) {
		return list.stream().sorted(compare).skip(1).findFirst().orElse(null);
	}
	
	public static void test1() {
		List<String> list = Arrays.asList("Bob", "Joe", "Tom");
		boolean result = Main.contains1(list, "Tom");
		System.out.println(result);
	}
	
	public static void test2() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1003, "Tom", 60000));
		list.add(new Employee(1002, "Harry", 70000));
		list.add(new Employee(1001, "Joe", 50000));
		System.out.println("2nd lowest paid employee => " + secondSmallest(list, Comparator.comparing(Employee::getSalary)));
				
	}
	
	public static void test3() {
		List<Manager> list = new ArrayList<>();
		list.add(new Manager(1003, "Tom", 60000, 700));
		list.add(new Manager(1002, "Harry", 70000, 400));
		list.add(new Manager(1001, "Joe", 50000, 500));
		System.out.println("2nd lowest paid manager => " + secondSmallest(list, Comparator.comparing(Manager::getSalary)));
		
	}
	
	public static void test4() {
		List<CheckingAccount> list = new ArrayList<>();
		list.add(new CheckingAccount(1001, 25.00));
		list.add(new CheckingAccount(1002, 35.00));
		list.add(new CheckingAccount(1003, 125.00));
		System.out.println("2nd lowest checking account => " 
		+ secondSmallest(list, Comparator.comparing(CheckingAccount::getBalance)));
		
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}	
		
		
	
}
