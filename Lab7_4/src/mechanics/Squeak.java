package mechanics;

public interface Squeak extends QuackBehavior {

	@Override
	default void quack() {
		// TODO Auto-generated method stub
		System.out.println("    sqeaking");
	}

}
