package Inbuilt;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main 
{
	static String[] FillHmArray(HashMap<String,Edge[]> hm)
	{
		hm.put("Kolhapur", new Edge[] {new Edge("Sindhudurg",10), new Edge("Satara",6), new Edge("Sangli", 5), new Edge("Ratnagiri", 19)});
		hm.put("Sangli", new Edge[] {new Edge("Osmanabad", 26),new Edge("Osmanabad", 26),new Edge("Solapur", 12),new Edge("Satara",4), new Edge("Kolhapur", 5)});
		hm.put("Sindhudurg", new Edge[] {new Edge("Kolhapur",10), new Edge("Satara",18), new Edge("Ratnagiri", 8)});
		hm.put("Ratnagiri", new Edge[] {new Edge("Pune", 13),new Edge("Raigad", 9), new Edge("Sindhudurg",8), new Edge("Satara",11), new Edge("Kolhapur", 19)});
		hm.put("Satara", new Edge[] {new Edge("Solapur",12),new Edge("Pune",7), new Edge("Raigad",15), new Edge("Ratnagiri",11), new Edge("Sangli", 4), new Edge("Sindhudurg", 18), new Edge("Kolhapur",6)});
		hm.put("Raigad", new Edge[] {new Edge("Mumbai", 5),new Edge("Pune", 9),new Edge("Satara",15), new Edge("Ratnagiri", 9)});
		hm.put("Pune", new Edge[] {new Edge("Buldhana", 34),new Edge("Ahmednagar", 10),new Edge("Thane", 7),new Edge("Mumbai", 4), new Edge("Beed", 21),new Edge("Raigad", 9),new Edge("Satara",7), new Edge("Ratnagiri", 13)});
		hm.put("Solapur", new Edge[] {new Edge("Osmanabad", 21),new Edge("Beed", 13),new Edge("Osmanabad", 21),new Edge("Sangli", 12),new Edge("Satara",12)});
		hm.put("Osmanabad", new Edge[] {new Edge("Sangli", 26),new Edge("Solapur", 21)});
		hm.put("Beed", new Edge[] {new Edge("Jalna", 22),new Edge("Buldhana", 11),new Edge("Ahmednagar", 19),new Edge("Pune", 21),new Edge("Solapur", 13)});
		hm.put("Mumbai", new Edge[] {new Edge("Thane", 2),new Edge("Pune", 4),new Edge("Raigad", 5)});
		hm.put("Thane", new Edge[] {new Edge("Nashik", 16),new Edge("Palghar", 3),new Edge("Pune", 7),new Edge("Mumbai", 2)});
		hm.put("Ahmednagar", new Edge[] {new Edge("Buldhana", 20),new Edge("Buldhana", 20),new Edge("Nashik", 11),new Edge("Palghar", 20),new Edge("Beed", 19),new Edge("Pune", 10),new Edge("Thane", 13)});
		hm.put("Palghar", new Edge[] {new Edge("Dhule", 15),new Edge("Thane", 3),new Edge("Ahmednagar", 20),new Edge("Nashik", 3)});
		hm.put("Nashik", new Edge[] {new Edge("Buldhana", 32),new Edge("Jalgoan", 14),new Edge("Dhule", 8),new Edge("Palghar", 3),new Edge("Thane", 16),new Edge("Ahmednagar", 11)});
		hm.put("Dhule", new Edge[] {new Edge("Jalgoan", 9),new Edge("Nandurbar", 4),new Edge("Palghar", 15),new Edge("Nashik", 8)});
		hm.put("Nandurbar", new Edge[] {new Edge("Jalgoan", 11),new Edge("Dhule", 4)});
		hm.put("Jalgoan", new Edge[] {new Edge("Buldhana", 7),new Edge("Nandurbar", 11),new Edge("Dhule", 9),new Edge("Nashik", 14)});
		hm.put("Buldhana", new Edge[] {new Edge("Jalna", 4),new Edge("Beed", 11),new Edge("Pune", 34),new Edge("Ahmednagar", 20),new Edge("Jalgoan", 7),new Edge("Ahmednagar", 20),new Edge("Nashik", 32)});
		hm.put("Jalna", new Edge[] {new Edge("Osmanabad", 30),new Edge("Beed", 22),new Edge("Buldhana", 4)});
		hm.put("Osmanabad", new Edge[] {new Edge("Jalna", 30),new Edge("Solapur", 21),new Edge("Sangli", 26)});

		String[] cityArray = new String[hm.size()];
		
		int idx = 0;
		for(String key : hm.keySet())
		{
			cityArray[idx] = key;
			idx++;
		}
		return cityArray;
	}
	public static void DisplayCities(HashMap<String,Edge[]> hm)
	{
		int i = 0;
		for(String key : hm.keySet())
		{
			System.out.println(++i + ") " + key);
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		HashMap<String,Edge[]> hm = new HashMap<>();
		String cityArray[] = FillHmArray(hm);
		
		System.out.println("Route Available in these cities :  ");
		DisplayCities(hm);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Current Location :  ");
		String source = sc.next();
		System.out.println();
		System.out.print("Enter Your Destination :  ");
		String destination = sc.next();
		System.out.println();
		Operations op1 = new Operations();
		op1.helper(source, destination, hm, cityArray);
	}
}
