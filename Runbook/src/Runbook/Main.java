package Runbook;

/**
 * Runbook.java
 * This is the main class of Runbook
 * This program manages books for a book store
 * Author: Claude C De-Tchambila
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Book[] b = new Book[100];
		Scanner sc = new Scanner(System.in);
		String choice, isbn;
		String title;
		double price;
		boolean found = false;
		int option;
		int copiesInStock = 0, num, index = 0, size = 0;
		/*
		 * b[0] = new Book("978-191-070-187-4", "Homo Deus", 448, 7); b[1] = new
		 * Book("978-0-06-250490-6", "Stride Toward Freedom", 214, 9); b[2] = new
		 * Book("0-09-192555-X ", " A Journey", 114, 6); b[3] = new
		 * Book("978-0-310-54651-1", "Gifted Hands", 300, 5);
		 */

		do {
			System.out.println("Menu");
			System.out.println("1. Add a book");
			System.out.println("2. Update a book");
			System.out.println("3. Purchase a book");
			System.out.println("4. Show all books");
			System.out.println("5. Exit");
			System.out.println();
			System.out.print("Enter your choice: ");
			choice = sc.next();

			switch (choice) {
			case "1":
				sc.nextLine();
				System.out.print("Enter the isbn of the book: ");
				isbn = sc.nextLine();
				System.out.print("Enter the title of the book: ");
				title = sc.nextLine();
				System.out.print("Enter the price of the book: ");
				price = sc.nextDouble();
				System.out.print("Enter the number of copies in stock: ");
				copiesInStock = sc.nextInt();
				b[size] = new Book(isbn, title, price, copiesInStock);
				size++;
				System.out.println("\nBook successfully added\n");
				break;

			case "2":
				System.out.print("Enter the isbn of the book: ");
				isbn = sc.next();

				for (int i = 0; i < size; i++) {
					if (isbn.equals(b[i].getIsbn())) {
						found = true;
						index = i;
						break;
					}
				}

				if (found) {
					sc.nextLine();
					System.out.print("Enter the new isbn of the book: ");
					isbn = sc.nextLine();
					b[index].setIsbn(isbn);

					System.out.print("Enter the new title of the book: ");
					title = sc.nextLine();
					b[index].setTitle(title);

					System.out.print("Enter the new price of the book: ");
					price = sc.nextDouble();
					b[index].setPrice(price);

					System.out.print("Enter new number of copies in stock: ");
					copiesInStock = sc.nextInt();
					b[index].setCopiesInStock(copiesInStock);

					System.out.println("\n>>> The book has succesfully been updated <<<\n");

				} else {
					System.out.println("Book not found");
				}
				break;

			case "3":
				System.out.println("Search book");
				System.out.println("1. By isbn ");
				System.out.print("2. By tilte: ");
				option = sc.nextInt();
				copiesInStock = 0;

				if (option == 1) {
					sc.nextLine();
					System.out.print("Enter the isbn of the book: ");
					isbn = sc.nextLine();
					for (int i = 0; i < size; i++) {
						if (isbn.equals(b[i].getIsbn())) {
							found = true;
							index = i;
							break;
						}
					}
					if (found) {
						System.out.print("Enter the number of copies: ");
						num = sc.nextInt();
						copiesInStock -= num;
						b[index].setCopiesInStock(copiesInStock);
					} else {
						System.out.println("Book not found\n");
					}
				} else {
					sc.nextLine();
					System.out.print("Enter the title of the book: ");
					title = sc.nextLine();
					for (int i = 0; i < size; i++) {
						if (title.equalsIgnoreCase(b[i].getTitle())) {
							found = true;
							index = i;
							break;
						}
					}
					if (found) {
						System.out.print("Enter the number of copies: ");
						num = sc.nextInt();
						copiesInStock -= num;
						b[index].setCopiesInStock(copiesInStock);
					} else {
						System.out.println("Book not found\n");
					}
				}

				break;

			case "4":
				System.out.printf("%-20s%-20s%-20s%-20s\n", "Title", "Isbn", "Price", "Copies in stock");
				for (int i = 0; i < size; i++) {
					System.out.printf("%-20s%-20s%-20.2f%-20d\n", b[i].getTitle(), b[i].getIsbn(), b[i].getPrice(),
							b[i].getCopiesInStock());
				}
				System.out.println();
				break;

			case "5":
				System.out.println(">>>You're exiting the program<<<");
				System.out.println("\nBye bye");
				break;

			default:
				System.out.println("Invalid choice!!!\n");

			}

		} while (!choice.equals("5"));
		sc.close();

	}

}
