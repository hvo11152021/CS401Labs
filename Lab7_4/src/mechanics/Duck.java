package mechanics;

public interface Duck extends FlyBehavior, QuackBehavior {
	
	default void behavior() {
		display();
		fly();
		quack();
		swim();
	}
	
	default void display() {
		System.out.println("    displaying");
	}
	
	default void swim() {
		System.out.println("    swimming");
	}
	
}
