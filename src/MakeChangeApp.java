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
}
