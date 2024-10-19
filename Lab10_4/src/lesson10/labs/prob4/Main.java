package lesson10.labs.prob4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Main newMain = new Main();
		Stream<Employee> emps = newMain.newEmpStream();
		newMain.printEmps(emps);
	}
	
	public Stream<Employee> newEmpStream(){
		return Arrays.asList(
				new Employee("Joe", "Davis", 120000),
				new Employee("John", "Sims", 110000), 
				new Employee("Joe", "Stevens", 200000),
				new Employee("Andrew", "Reardon", 80000), 
				new Employee("Joe", "Cummings", 760000),
				new Employee("Steven", "Walters", 135000), 
				new Employee("Thomas", "Blake", 111000),
				new Employee("Alice", "Richards", 101000), 
				new Employee("Donald", "Trump", 100000)).stream();
	}

	public String asString(Stream<Employee> employees) {
        return employees.map(e -> fullName(e) + " | " +
                (salaryGreaterThan100000(e) ? "Salary more than 100000" : "Salary less/= to 100000") + " | " +
                (lastNameAfterM(e) ? "Last Name > M" : "Last Name <= M"))
                .reduce((s1, s2) -> s1 + "\n" + s2)
                .orElse("");
    }

	private void printEmps(Stream<Employee> emps) {
		System.out.println(asString(emps));
	}

    public static boolean salaryGreaterThan100000(Employee e) {
        return e.getSalary() > 100000;
    }

    public static boolean lastNameAfterM(Employee e) {
        return e.getLastName().compareToIgnoreCase("M") > 0;
    }

    public static String fullName(Employee e) {
        return e.getFirstName() + " " + e.getLastName();
    }

}
