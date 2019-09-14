import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		double checkoutTotal = checkoutTotal(keyboard);
		double amountPaid = amountPaid(keyboard, checkoutTotal);
		if (amountPaid != 0) {
			System.out.println("Checkout total: $" + checkoutTotal);
			changeDue(amountPaid, checkoutTotal);
			System.out.println("\nHave a nice day!");
		}

		keyboard.close();

	}

	public static double checkoutTotal(Scanner keyboard) {
		double output, priceOfNextItem;
		do {
			System.out.print("Enter price of item: $");
			priceOfNextItem = keyboard.nextDouble();
			if (priceOfNextItem < 0) {
				System.out.println("The price cannot be negative");
			}
		} while (priceOfNextItem < 0);
		output = priceOfNextItem;
		do {
			do {
				System.out.print("Enter price of next item or enter 0 to checkout: $");
				priceOfNextItem = keyboard.nextDouble();
				if (priceOfNextItem < 0) {
					System.out.println("The price cannot be negative.");
					continue;
				}
			} while (priceOfNextItem < 0);
			output += priceOfNextItem;
		} while (priceOfNextItem != 0);

		output *= 100;
		output = (int) output;
		output /= 100;

		System.out.println("Checkout total: $" + output);
		return output;

	}

	public static double amountPaid(Scanner keyboard, double checkoutTotal) {
		String anotherPayment;
		double output, paidAmount;
		do {
			System.out.print("Enter amount paid to cashier: $");
			paidAmount = keyboard.nextDouble();
			if (paidAmount < 0) {
				System.out.println("Cannot pay a negative amount.");
			}
		} while (paidAmount < 0);

		output = paidAmount;

		while (output < checkoutTotal) {
			System.out.println("Amount paid is insufficient.");
			System.out.println("Would you like to make an additional payment? (Y/N)");
			anotherPayment = keyboard.next().toLowerCase();

			if (anotherPayment.equalsIgnoreCase("y")) {
				do {
					System.out.println("Enter next payment amount: $");
					paidAmount = keyboard.nextDouble();
					if (paidAmount < 0) {
						System.out.println("Cannot pay a negative amount.");
					}
				} while (paidAmount < 0);
			} else if (anotherPayment.equalsIgnoreCase("n")) {
				System.out.println("Cashier returns: $" + output);
				output = 0;
				break;
			} else {
				System.out.println("Invalid response. Try again.");
			}
			output += paidAmount;
		}
		if (output == 0) {
			System.out.println("Have a nice day!");
		} else {
			System.out.println("Total paid: $" + output);
		}
		return output;
	}

	public static double changeDue(double amountPaid, double checkoutTotal) {
		double output = amountPaid - checkoutTotal, twenties, tens, fives, ones, quarters, dimes, nickels, pennies;
		String currencyMsg;
		if (amountPaid == checkoutTotal) {
			System.out.println("No change due.");
		} else {
			System.out.print("Change due ($" + checkoutTotal + "):");
			if (output / 20 >= 1) {
				twenties = (int) (output / 20);
				output = output - (twenties * 20);
				currencyMsg = (output >= .005) 
							? (twenties == 1)
								? "twenty dollar bill, "
								: "twenty dollar bills, "
							: (twenties == 1)
								? "twenty dollar bill."
								: "twenty dollar bills.";
				System.out.print((int) twenties + " " + currencyMsg);
			}
			if (output / 10 >= 1) {
				tens = (int) (output / 10);
				output = output - (tens * 10);
				currencyMsg = (output >= .005) 
						? (tens == 1)
								? "ten dollar bill, "
								: "ten dollar bills, "
						: (tens == 1)
								? "ten dollar bill."
								: "ten dollar bills.";
				System.out.print((int) tens + " " + currencyMsg);
			}
			if (output / 5 >= 1) {
				fives = (int) (output / 5);
				output = output - (fives * 5);
				currencyMsg = (output >= .005) 
						? (fives == 1)
								? "five dollar bill, "
								: "five dollar bills, "
						: (fives == 1)
								? "five dollar bill."
								: "five dollar bills.";
				System.out.print((int) fives + " " + currencyMsg);
			}
			if (output / 1 >= 1) {
				ones = (int) (output / 1);
				output = output - (ones);
				currencyMsg = (output >= .005) 
						? (ones == 1)
								? "one dollar bill, "
								: "one dollar bills, "
						: (ones == 1)
								? "one dollar bill."
								: "one dollar bills.";
				System.out.print((int) ones + " " + currencyMsg);
			}
			if (output / .25 >= 1) {
				quarters = (int) (output / .25);
				output = output - (quarters * .25);
				currencyMsg = (output >= .005) 
						? (quarters == 1)
								? "quarter, "
								: "quarters, "
						: (quarters == 1)
								? "quarter."
								: "quarters.";
				System.out.print((int) quarters + " " + currencyMsg);
			}
			if (output / .10 >= 1) {
				dimes = (int) (output / .10);
				output = output - (dimes * .10);
				currencyMsg = (output >= .005) 
						? (dimes == 1)
								? "dime, "
								: "dimes, "
						: (dimes == 1)
								? "dime."
								: "dimes.";
				System.out.print((int) dimes + " " + currencyMsg);
			}
			if (output / .05 >= 1) {
				nickels = (int) (output / .05);
				output = output - (nickels * .05);
				currencyMsg = (output >= .005) 
						? (nickels == 1)
								? "nickel, "
								: "nickels, "
						: (nickels == 1)
								? "nickel."
								: "nickels.";
				System.out.print((int) nickels + " " + currencyMsg);
			}
			if (((output + 0.005) * 100) >= 1) {
				pennies = (int) ((output + 0.005) * 100);
				currencyMsg = (pennies == 1) 
						? "penny."
						: "pennies.";
				System.out.print((int) pennies + " " + currencyMsg);
			}
		}
		return output;
	}
}
