package lab9_12;

import java.util.Optional;

public class MySingletonLazy {
	private static MySingletonLazy instance = null;

    private MySingletonLazy() {
        System.out.println("Test: New instance created");
    }

    public static MySingletonLazy getInstance() {
        instance = Optional.ofNullable(instance)
            .orElseGet(MySingletonLazy::new);
        return instance;
    }

	 
    public static void main(String[] args) {
        getInstance();
    }
}
