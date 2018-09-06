package Runbook;

import java.util.Scanner;

public class Book {
	private String isbn;
	private String title;
	private double price;
	private int copiesInStock;

	public Book() {

	}

	public Book(String isbn, String title, double price, int copiesInStock) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.copiesInStock = copiesInStock;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getCopiesInStock() {
		return copiesInStock;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCopiesInStock(int copiesInStock) {
		this.copiesInStock = copiesInStock;
	}

	private double discount(int num) { // num refers to the number of books purchased
		final double PERCENTAGE_DISCOUNT = 0.10;
		double discountValue;

		discountValue = (price * PERCENTAGE_DISCOUNT) * num;
		return discountValue;
	}

	public double totalBookValue() {
		int numberCopies;
		Scanner sc = new Scanner(System.in);
		double discountAmount, total;

		System.out.print("Please enter the number of copies to purchase: ");
		numberCopies = sc.nextInt();
		discountAmount = discount(numberCopies);
		total = (price * numberCopies) - discountAmount;
		copiesInStock -= numberCopies;
		sc.close();
		return total;
	}

	public String toString() {
		String output;

		output = "Title: " + title + "\n";
		output += "Isbn: " + isbn + "\n";
		output += String.format("Price: %.2f\n", price);
		output += "Copies in stock: " + copiesInStock + "\n";

		return output;
	}
}
