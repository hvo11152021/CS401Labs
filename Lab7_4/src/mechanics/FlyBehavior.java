package mechanics;

interface FlyBehavior {
	default void fly() {
		System.out.println("    flying with wings");
	}
}
