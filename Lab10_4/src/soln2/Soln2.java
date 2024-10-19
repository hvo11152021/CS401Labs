package soln2;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import lesson10.labs.prob4.Employee;
import lesson10.labs.prob4.Main;

class Soln2 {

	@Test
	void test() {
		Employee emp1 = new Employee("John", "Doe", 120000);
        Employee emp2 = new Employee("Alice", "Cooper", 90000);
        Employee emp3 = new Employee("Bob", "Smith", 95000);

        Stream<Employee> employees = Stream.of(emp1, emp2, emp3);
        Main newMain = new Main();
        System.out.println(newMain.asString(employees));
	}

}
