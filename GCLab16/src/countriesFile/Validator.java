package countriesFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
	Scanner scnr = new Scanner(System.in);

	public static String getName(Scanner scnr) {

		String name = scnr.nextLine();
		
		while (name.length() == 0) {
			System.out.println("Oops! Please enter a name: ");
			name = scnr.nextLine();
		}
		return name;
	}

	public static int getInt(Scanner scnr) {
		int num = 0;
		
		try {
			num = scnr.nextInt();
			scnr.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Please enter a whole number.");
			scnr.nextLine();
			return getInt(scnr);
		}
		
		return num;

	}
}
