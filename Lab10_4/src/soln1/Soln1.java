package soln1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import lesson10.labs.prob4.Employee;
import lesson10.labs.prob4.Main;

class Soln1 {

	@Test
	void test() {
        Employee emp1 = new Employee("Alice", "Nelson", 120000);
        Employee emp2 = new Employee("Bob", "Miller", 90000);
        Employee emp3 = new Employee("Charlie", "Olsen", 130000);
        Employee emp4 = new Employee("David", "Adams", 150000);

        Stream<Employee> employeeStream1 = Stream.of(emp1, emp2, emp3, emp4);

        Main newMain = new Main();
        
        assertEquals("Alice Nelson, Charlie Olsen", newMain.asString(employeeStream1));
	}
}
