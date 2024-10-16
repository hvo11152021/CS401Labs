package lab8_7;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}
}

class Apple {
	private double weight;

	public Apple(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}
}

class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

public class Main {
	
	Function<Employee, String> getName = (Employee e) -> e.getName();
	Function<Employee, String> getName2 = Employee::getName;

//	B.
	BiConsumer<Employee, String> setName = (Employee e, String s) -> e.setName(s);
	BiConsumer<Employee, String> setName2 = Employee::setName;

//	C.
	BiFunction<String, String, Integer> compareStr = (String s1, String s2) -> s1.compareTo(s2);
	BiFunction<String, String, Integer> compareStr2 = String::compareTo;

//	D.
	BiFunction<Integer, Integer, Double> power = (x, y) -> Math.pow(x, y);

//	E.
	Function<Apple, Double> getWeight = (Apple a) -> a.getWeight();
	Function<Apple, Double> getWeight2 = Apple::getWeight;

//	F.
	Function<String, Integer> parseInt = (String x) -> Integer.parseInt(x);
	Function<String, Integer> parseInt2 = Integer::parseInt;

//	G.
	EmployeeNameComparator comp = new EmployeeNameComparator();
	BiFunction<Employee, Employee, Integer> compareEmp = (Employee e1, Employee e2) -> comp.compare(e1, e2);
	BiFunction<Employee, Employee, Integer> compareEmp2 = comp::compare;
	
	void evaluator() {
        Employee emp1 = new Employee("Hy");
        Employee emp2 = new Employee("Karan");
        Employee emp3 = new Employee("Ben");

        Apple apple1 = new Apple(1.2);
        Apple apple2 = new Apple(1.5);
        
        System.out.println(getName.apply(emp1));
        System.out.println(getName2.apply(emp2));

        setName.accept(emp1, "Loc");
        System.out.println(emp1.getName());
        setName2.accept(emp2, "Sparsh");
        System.out.println(emp2.getName());

        System.out.println(compareStr.apply("abc", "xyz"));
        System.out.println(compareStr2.apply("xyz", "abc"));

        System.out.println(power.apply(2, 3));

        System.out.println(getWeight.apply(apple1));
        System.out.println(getWeight2.apply(apple2));

        System.out.println(parseInt.apply("123"));
        System.out.println(parseInt2.apply("456"));

        System.out.println(compareEmp.apply(emp1, emp3));
        System.out.println(compareEmp2.apply(emp2, emp3));
	}

	public static void main(String[] args) {
		Main instance = new Main();
		instance.evaluator();
	}
}
