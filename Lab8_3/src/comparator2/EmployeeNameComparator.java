package comparator2;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		int nameComparison = e1.name.compareTo(e2.name);
	    if (nameComparison != 0) return nameComparison;
	    else return Double.compare(e1.salary, e2.salary);
	}
}
