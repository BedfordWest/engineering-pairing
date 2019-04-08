package IfsAndLoops;

import java.util.ArrayList;
import java.util.List;

public class IfExercise {

	public static void main(String[] args) {
		IfExercise ifExercise = new IfExercise();
		ifExercise.addFoodToCart();
		ifExercise.checkout();
	}

	private List<String> cart = new ArrayList<>();

	private void addFoodToCart() {
		if(bananaExists()) { cart.add("banana"); }
		if(meatCounterExists()) {
			if(steakExists()) {
				cart.add("steak");
			}
			if(brisketExists()) {
				cart.add("brisket");
			}
		}
		if(cookieExists()) { cart.add("cookie"); }
		if(sweetBabyRaysExists()) {
			cart.add("sweetBabyRays");
		}
	}

	private void checkout() {
		cart.forEach(System.out::println);
	}

	private boolean bananaExists() {
		return true;
	}

	private boolean meatCounterExists() {
		return true;
	}

	private boolean steakExists() {
		return false;
	}

	private boolean brisketExists() {
		return true;
	}

	private boolean cookieExists() {
		return true;
	}

	private boolean sweetBabyRaysExists() {
		System.out.println("Oh no, Sweet Baby Ray's is really the only thing I wanted today!");
		return false;
	}

}
