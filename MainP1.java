package assignment1;

import java.util.Map;

public class MainP1 {

	public static void main(String[] args) 
	{
		P1 p1 = new P1();
		
		p1.saveCountryCapital("India", "Delhi");
		p1.saveCountryCapital("China", "Beijing");
		p1.saveCountryCapital("Qatar", "Doha");
		
		System.out.println(p1.getCapital("India"));
		System.out.println(p1.getCountry("Doha"));
		System.out.println(p1.createArrayList());
		
		Map<String, String> m2 = p1.iterator();
		System.out.println(m2);

	}

}
