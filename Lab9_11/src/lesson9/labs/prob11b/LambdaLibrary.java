package lesson9.labs.prob11b;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public static final Function<List<Employee>, String> EMPS_SIX_FIGURES = (emps -> emps.stream()
			  .filter(e -> e.getSalary()>100000)
			  .filter(e -> {
				  char range = e.getLastName().charAt(0);
				  return range >= 'N' && range <= 'Z';
			  })
			  .map(e -> e.getFirstName() + " " + e.getLastName())
			  .collect(Collectors.joining(", ")));
}
