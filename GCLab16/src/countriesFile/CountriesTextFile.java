package countriesFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesTextFile {

	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) throws IOException {

		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}

	}

	public static void appendToFile(Country countries) throws IOException {

		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		String line = countries.getName() + "\t" + countries.getPopulation();
		//String line = String.format("%s\t%d", countries.getName(), countries.getPopulation());
		List<String> countriesToAdd = Arrays.asList(line);
		Files.write(filePath, countriesToAdd, StandardOpenOption.APPEND);
	}

	public static List<Country> readFromFile() {
		try {

			List<String> lines = Files.readAllLines(filePath);
			List<Country> countries = new ArrayList<>();
			
			for (String line : lines) {
				String[] parts = line.split("\t");
				Country place = new Country();
				place.setName(parts[0]);
				int val = new BigDecimal(parts[1]).intValue();
				place.setPopulation(val);
				countries.add(place);
			}
			return countries;

		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}

	}
}
