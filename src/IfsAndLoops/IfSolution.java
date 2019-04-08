package IfsAndLoops;

import java.util.*;

public class IfSolution {

	private List<GroceryItem> cart = new ArrayList<>();

	private final int BANANAS = 3;
	private final int COOKIES = 5;
	private final int STEAK = 0;
	private final int BRISKET = 1;
	private final int SWEETBABYRAYS = 0;
	private final boolean HAS_MEAT = true;

	public static void main(String[] args) {
		IfSolution ifSolution = new IfSolution();
		GroceryStore store = ifSolution.initializeStore();
		ifSolution.addFoodToCart(store);
		ifSolution.checkout();
	}

	private GroceryStore initializeStore() {
		return new GroceryStore()
			.withMeatCounter(HAS_MEAT)
			.withStock(GroceryItem.BANANA, BANANAS)
			.withStock(GroceryItem.COOKIE, COOKIES)
			.withStock(GroceryItem.STEAK, STEAK)
			.withStock(GroceryItem.BRISKET, BRISKET)
			.withStock(GroceryItem.SWEETBABYRAYS, SWEETBABYRAYS);
	}

	private class GroceryStore {
		EnumMap<GroceryItem, Integer> stock = new EnumMap<>(GroceryItem.class);
		boolean hasMeatCounter = false;
		GroceryStore withMeatCounter(boolean counterAvailable) {
			this.hasMeatCounter = counterAvailable;
			return this;
		}
		GroceryStore withStock(GroceryItem item, int numberInStock) {
			this.stock.put(item, numberInStock);
			return this;
		}
		Integer quantity(GroceryItem item) {
			return stock.get(item);
		}
	}

	private interface Shoppable {
		boolean isInStore(GroceryStore store);
	}

	private enum GroceryItem implements Shoppable {
		BANANA, STEAK, BRISKET, COOKIE, SWEETBABYRAYS;

		public boolean isInStore(GroceryStore store) {
			return (store.quantity(this) > 0);
		}
	}

	private void addFoodToCart(GroceryStore store) {
		Arrays.stream(GroceryItem.values())
			.filter(item -> store.quantity(item) > 0)
			.forEach(item -> cart.add(item));
	}

	private void checkout() {
		cart.forEach(System.out::println);
	}




}
