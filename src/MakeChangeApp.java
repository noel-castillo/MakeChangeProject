import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		double priceOfItem = priceOfItem(keyboard);
		double amountPaid = amountPaid(keyboard, priceOfItem);
		System.out.println(changeDue(amountPaid, priceOfItem));

	}

	public static double priceOfItem(Scanner keyboard) {
		System.out.print("Enter price of item: ");
		double output = keyboard.nextDouble();
		return output;

	}

	public static double amountPaid(Scanner keyboard, double priceOfItem) {
		String anotherPayment = "";
		System.out.print("Enter amount paid to cashier: ");
		double output = keyboard.nextDouble();
		while (output < priceOfItem) {
			System.out
					.println("Amount paid is insufficient." + "\nWould you like to make an additional payment? (Y/N)");
			anotherPayment = keyboard.next().toLowerCase();

			if (anotherPayment.equalsIgnoreCase("y")) {
				System.out.println("Enter next payment amount: ");
				output += keyboard.nextDouble();
			} else if (anotherPayment.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.println("Invalid response. Try again.");
			}

		}
		return output;
	}

	public static double changeDue(double amountPaid, double priceOfItem) {
		double output = amountPaid - priceOfItem, twenties, tens, fives, ones, quarters, dimes, nickels, pennies;

		if (amountPaid == priceOfItem) {
			System.out.println("No change is due");
		} else {
			System.out.print("Change due is: ");
			if (output / 20 >= 1) {
				twenties = (int) (output / 20);
				output = output - (twenties * 20);
				System.out.print((int) twenties + " twenties, ");
				System.out.println(output);
			}
			if (output / 10 >= 1) {
				tens = (int) (output / 10);
				output = output - (tens * 10);
				System.out.print((int) tens + " tens, ");
				System.out.println(output);
			}
			if (output / 5 >= 1) {
				fives = (int) (output / 5);
				output = output - (fives * 5);
				System.out.print((int) fives + " fives, ");
				System.out.println(output);
			}
			if (output / 1 >= 1) {
				ones = (int) (output / 1);
				output = output - (ones);
				System.out.print((int) ones + " ones, ");
				System.out.println(output);
			}
			if (output / .25 >= 1) {
				quarters = (int) (output / .25);
				output = output - (quarters * .25);
				System.out.print((int) quarters + " quarters, ");
				System.out.println(output);
			}
			if (output / .10 >= 1) {
				dimes = (int) (output / .10);
				output = output - (dimes * .10);
				System.out.print((int) dimes + " dimes, ");
				System.out.println(output);
			}
			if (output / .05 >= 1) {
				nickels = (int) (output / .05);
				output = output - (nickels * .05);
				System.out.print((int) nickels + " nickels,");
				System.out.println(output);
			}
			if ((output * 100) >= 1) {
				pennies = (int) ((output + 0.01) * 100);
				System.out.print(" and " + pennies + " pennies.");
				System.out.println(output);
			}
		}
		return output;
	}
}
