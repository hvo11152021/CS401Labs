package mechanics;

public interface CannotFly extends FlyBehavior {

	@Override
	default void fly() {
		// TODO Auto-generated method stub
		System.out.println("    cannot fly");
	}
	
}
