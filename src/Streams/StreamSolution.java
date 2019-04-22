package Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamSolution {

	public static void main(String[] args) {
		StreamSolution streamSolution = StreamSolution.withDefaultProducts();
		streamSolution.updateStock();
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

	public static StreamSolution withDefaultProducts() {
		StreamSolution streamSolution = new StreamSolution();
		streamSolution.products.add(Product.BRISKET.withExpiry(false).withQuantity(3));
		streamSolution.products.add(Product.BANANA.withExpiry(true).withQuantity(8));
		streamSolution.products.add(Product.OATMEAL.withExpiry(false).withQuantity(13));
		streamSolution.products.add(Product.TUNA.withExpiry(true).withQuantity(9));
		streamSolution.products.add(Product.BREAD.withExpiry(false).withQuantity(35));
		return streamSolution;
	}

	private void updateStock() {
		products.stream()
			.filter(product -> !product.isExpired)
			.forEach(product -> { if(product.quantity < 20) { product.quantity = 20; } System.out.println(product.toString()); });
	}

}
