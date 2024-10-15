package mechanics;

public interface MuteQuack extends QuackBehavior {

	@Override
	default void quack() {
		// TODO Auto-generated method stub
		System.out.println("    cannot quack");
	}

}
