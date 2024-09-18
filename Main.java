import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
		Scanner keyboard = new Scanner(System.in);
		// Prompt user with options in a loop
		int choice, ounces, brewTemp, count = 0;
		String name;
		double price;

		do {
			System.out.println("1) Enter new Tea");
			System.out.println("2) Enter new Yerba Mate");
			System.out.println("3) Exit");
			System.out.print(">>");
			choice = keyboard.nextInt();

			switch (choice) {
				case 1: // Tea
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();

					// Create a Tea, put into array
					inventory[count] = new Tea(name, ounces, price, brewTemp);

					System.out.println("Your tea order has been added: " + inventory[count]);
					count++;
					break;
				case 2: // Yerba Mate
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();

					// Create a Yerba Mate, put into array
					inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0);

					System.out.println("Your yerba mate order has been added: " + inventory[count]);
					count++;
					break;
			}

		} while (choice != 3);
	}

	public static double findAveragePrice(CaffeinatedBeverage[] inventory) {
		double retVal = 0;
		double count = 0;

		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				retVal += inventory[i].getPrice();
				count += 1;
			}
		}

		return retVal / count;
	}

	public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory) {
		YerbaMate highestPrice = null;

		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] instanceof YerbaMate) {
				YerbaMate testMate = (YerbaMate) inventory[i];

				if (highestPrice == null) {
					highestPrice = testMate;
				} else if (highestPrice.getPrice() < testMate.getPrice()) {
					highestPrice = testMate;
				}
			}
		}

		return highestPrice;
	}

	public static int howManyTeasOrdered(CaffeinatedBeverage[] inventory) {
		int teaOrders = 0;

		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null && !(inventory[i] instanceof YerbaMate)) {
				teaOrders++;
			}
		}

		return teaOrders;
	}
}