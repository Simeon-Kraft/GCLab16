package countriesFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		boolean more = true;
		int userNum = 0;
		
		System.out.println("Welcome to the Country Maintenance Application.\n");
		
		while(more) {
			System.out.println("Make your selection:\n1. See list of countries \n2. Add a country \n3. Quit");
			userNum = Validator.getInt(scnr);
			
			while(userNum < 1 || userNum > 3) {
				System.out.println("Please select either 1, 2, or 3.");
				userNum = Validator.getInt(scnr);
			}
			
			switch (userNum) {
			
			case 1:
				printCountries();
				break;
			case 2:
				makeCountry(scnr);
				break;
			case 3:
				more = false;
				break;
			default:
				System.out.println("Oops!");
			
			}
			
			
		}
		System.out.println("Thanks for all your hard work.");
		
		scnr.close();
	}
	
	public static void makeCountry(Scanner scnr) throws IOException {
		System.out.println("Enter the country's name: ");
		String name = Validator.getName(scnr);
		System.out.println("Enter the country's population: ");
		int pop = Validator.getInt(scnr);
		
		Country place = new Country(name, pop);
		System.out.println(pop);
		CountriesTextFile.appendToFile(place);
		
	}
	
	public static void printCountries() {
		
		List<Country> list = CountriesTextFile.readFromFile();
		
		System.out.println("Countries by List \n=================\n");
		for (Country place : list) {
			System.out.println(place + "\n");
		}
		
	}

}
