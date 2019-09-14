import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		double priceOfItem = priceOfItem(keyboard);
		double amountPaid = amountPaid(keyboard, priceOfItem);
		changeDue(amountPaid, priceOfItem);

	}

	public static double priceOfItem(Scanner keyboard) {
		System.out.print("Enter price of item: ");
		double output = keyboard.nextDouble();
		return output;

	}

	public static double amountPaid(Scanner keyboard, double priceOfItem) {
		String anotherPayment;
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
		boolean done = false;
		if (amountPaid == priceOfItem) {
			System.out.println("No change is due");
		} else {
			System.out.print("Change due is: ");
			if (output / 20 >= 1) {
				twenties = (int) (output / 20);
				output = output - (twenties * 20);
				if ((int) twenties == 1) {
					System.out.println((int) twenties + " twenty, ");
				} else {
					System.out.print((int) twenties + " twenties, ");
				}
			}
			if (output / 10 >= 1) {
				tens = (int) (output / 10);
				output = output - (tens * 10);
				if ((int) tens == 1) {
					System.out.println((int) tens + " ten, ");
				} else {
					System.out.print((int) tens + " tens, ");
				}
			}
			if (output / 5 >= 1) {
				fives = (int) (output / 5);
				output = output - (fives * 5);
				if ((int) fives == 1) {
					System.out.println((int) fives + " five, ");
				} else {
					System.out.print((int) fives + " five, ");
				}
			}
			if (output / 1 >= 1) {
				ones = (int) (output / 1);
				output = output - (ones);
				if ((int) ones == 1) {
					System.out.println((int) ones + " dollar, ");
				} else {
					System.out.print((int) ones + " dollars, ");
				}
			}
			if (output / .25 >= 1) {
				quarters = (int) (output / .25);
				output = output - (quarters * .25);
				if ((int) quarters == 1) {
					System.out.println((int) quarters + " quarter, ");
				} else {
					System.out.print((int) quarters + " quarters, ");
				}
			}
			if (output / .10 >= 1) {
				dimes = (int) (output / .10);
				output = output - (dimes * .10);
				if ((int) dimes == 1) {
					System.out.println((int) dimes + " dime, ");
				} else {
					System.out.print((int) dimes + " dimes, ");
				}
			}
			if (output / .05 >= 1) {
				nickels = (int) (output / .05);
				output = output - (nickels * .05);
				if ((int) nickels == 1) {
					System.out.println((int) nickels + " nickel, ");
				} else {
					System.out.print((int) nickels + " nickels, ");
				}
			}
			if ((output * 100) >= 1) {
				pennies = (int) ((output + 0.005) * 100);
				if ((int) pennies == 1) {
					System.out.println((int) pennies + " penny. ");
				} else {
					System.out.print((int) pennies + " pennies. ");
				}
			}
		}
		return output;
	}
}
