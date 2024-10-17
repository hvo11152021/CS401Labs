package lesson9.labs.prob3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Employee {
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	int salary;
	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	public Employee() {
		// generate for ease of instance creation
	}
	@Override
	public String toString() {
		return "[" + name + ", " + salary+"]";
	}
	
	enum SortMethod {BYNAME, BYSALARY};
	Function<Employee, String> byName = n -> n.getName(); 
	Function<Employee, Integer> bySalary = s -> s.getSalary();
	
	public void sort(List<Employee> empList, final SortMethod method) {
		if (method == SortMethod.BYNAME) {
			Collections.sort(empList, Comparator.comparing(byName).thenComparing(bySalary));
		} else {
			Collections.sort(empList, Comparator.comparing(bySalary).reversed().thenComparing(byName));
		}
	}
	
	public static void main(String[] args) {
		
		
		List<Employee> list = new ArrayList<Employee>() {
			{
				add(new Employee("Joe", 50000));
				add(new Employee("Jim", 75000));
				add(new Employee("Tom", 80000));
				add(new Employee("Jim", 70000));
				add(new Employee("Steve", 55000));
				add(new Employee("Jim", 100000));
				add(new Employee("Joe", 59000));
				add(new Employee("Rich", 88000));
			}
		};
		//expected output:
		//[[Jim, 100000], [Jim, 75000], [Jim, 70000], [Joe, 59000], [Joe, 50000], [Rich, 88000], [Steve, 55000], [Tom, 80000]]
		Employee e = new Employee();
		e.sort(list, Employee.SortMethod.BYNAME);
		System.out.println(list);
		e.sort(list, Employee.SortMethod.BYSALARY);
		System.out.println(list);
	}
}

