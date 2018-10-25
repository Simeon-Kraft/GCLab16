package countriesFile;

public class Country {

	private String name;
	private int population;
	
	public Country() {}
	
	public Country (String name, int population) {
		this.name = name;
		this.population = population;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public double getPopulation() {
		return population;
	}
	
	@Override
	public String toString() {
		return name + " has a population of " + population;
	}
}
