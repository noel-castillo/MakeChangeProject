import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		double priceOfItem = priceOfItem(keyboard);
		
	}

	public static double priceOfItem(Scanner keyboard) {
		System.out.print("Enter price of item: ");
		double output = keyboard.nextDouble();
		return output;
	}
	public static double amountPaid(Scanner keyboard) {
		System.out.print("Enter amount paid to cashier: ");
		double output = keyboard.nextDouble();
		return output;
	}
}
