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
		String currencyMsg;
		boolean done = false;
		if (amountPaid == priceOfItem) {
			System.out.println("No change is due");
		} else {
			System.out.print("Change due is: ");
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
