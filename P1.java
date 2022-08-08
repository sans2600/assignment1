/*
 * 1. Develop a java class with a instance variable M1 (HashMap) 
 * create a method saveCountryCapital(String CountryName, String capital) , 
 * the method should add the passed country and capital as key/value in
 *  the map M1 and return the Map (M1).
Key- Country Value - Capital
India Delhi
Japan Tokyo
2. Develop a method getCapital(String CountryName) which returns the 
capital for the country passed, from the Map M1 created in step 1.
3. Develop a method getCountry(String capitalName) which returns the 
country for the capital name, passed from the Map M1 created in step 1.
4. Develop a method which iterates through the map M1 and creates another
map M2 with Capital as the key and value as Country and returns the Map M2.
Key – Capital Value – Country
Delhi India
Tokyo Japan
5. Develop a method which iterates through the map M1 and creates an ArrayList with all the Country names stored as keys. This method should return the ArrayList.
NOTE: You can test the methods using a main method.
 */


package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P1 {
	
	Map<String, String> m1 = new HashMap<String, String>();
	
	public String saveCountryCapital(String CountryName, String Capital)
	{
		return m1.put(CountryName, Capital);
	}
	
	public String getCapital(String CountryName)
	{
		return m1.get(CountryName);
	}
	
	public String getCountry(String capitalName)
	{
		Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry<String, String> map = it.next();
			
			if(map.getValue().equals(capitalName))
			{
				return map.getKey();
			}
		}
		return null;
	}
	
	public Map<String, String> iterator()
	{
		Map<String, String> m2 = new HashMap<String, String>();
	
		Set<Entry<String, String>> set = m1.entrySet();
		Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<String, String> map = it.next();
			m2.put(map.getValue(), map.getKey());
			//System.out.println(it.next());
		}
		
		return m2;
	}
	
	public ArrayList<String> createArrayList()
	{
		ArrayList<String> al = new ArrayList<>();
		
		Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry<String, String> map = it.next();
			al.add(map.getKey());
			
		}
		return al;
	}

}
