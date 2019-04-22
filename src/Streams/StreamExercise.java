package Streams;

import java.util.ArrayList;
import java.util.List;

/**
 * As a grocery store stock vendor, you need to adjust the stock of your product based on what is good, what is missing,
 * etc. The initial implementation provided in this exercise loops through the product using a series of for loops. Your
 * task is to switch this implementation over to use streams, instead. As you do so, compare the two approaches. What do
 * you think you gain or lose by using streams? Which feels more intuitive to you? When would you use one approach vs.
 * the other?
 */
public class StreamExercise {

	public static void main(String[] args) {
		StreamExercise streamExercise = StreamExercise.withDefaultProducts();
		streamExercise.removeExpired();
		streamExercise.stockTo20();
		streamExercise.printStock();
	}

	private enum Product {
		BRISKET, BANANA, OATMEAL, TUNA, BREAD;
		boolean isExpired;
		int quantity;

		public Product withExpiry(boolean expiry) {
			this.isExpired = expiry;
			return this;
		}

		public Product withQuantity(int num) {
			this.quantity = num;
			return this;
		}

		@Override
		public String toString() {
			return String.format("Product: %s, Expired?: %s, Quantity: %d", name(), isExpired, quantity);
		}

	}

	private List<Product> products = new ArrayList<>();

	public static StreamExercise withDefaultProducts() {
		StreamExercise streamExercise = new StreamExercise();
		streamExercise.products.add(Product.BRISKET.withExpiry(false).withQuantity(3));
		streamExercise.products.add(Product.BANANA.withExpiry(true).withQuantity(8));
		streamExercise.products.add(Product.OATMEAL.withExpiry(false).withQuantity(13));
		streamExercise.products.add(Product.TUNA.withExpiry(true).withQuantity(9));
		streamExercise.products.add(Product.BREAD.withExpiry(false).withQuantity(35));
		return streamExercise;
	}


	private void removeExpired() {
		List<Product> noExpiredProducts = new ArrayList<>();
		for(Product product:products) {
			if(!product.isExpired) {
				noExpiredProducts.add(product);
			}
		}
		this.products = noExpiredProducts;
	}

	private void stockTo20() {
		for(Product product:products) {
			if(product.quantity < 20) { product.quantity = 20; }
		}
	}

	private void printStock() {
		for(Product product:products) {
			System.out.println(product.toString());
		}
	}

}
