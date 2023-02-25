package Inbuilt;

import java.util.*;
import java.lang.*;
import java.io.*;


public class Operations 
{
	private String changeLikeKey(String s)
	{
		String ans = "";
		String firstChar = s.charAt(0) + "";
		firstChar = firstChar.toUpperCase();
		String remaining = s.substring(1);
	    ans += firstChar + remaining;
	    ans.trim();
		return ans;
	}		

	public String helper(String source, String destination, HashMap<String,Edge[]> hm, String cityArray[])
	{
		// Change according to HashMap Key
		source = changeLikeKey(source);
		destination = changeLikeKey(destination);
		
		HashMap<String, String> parent = new HashMap<>();
		for(int i = 0; i < cityArray.length; i++)
		{
			parent.put(cityArray[i], cityArray[i]);
		}
		
		HashMap<String, Integer> distance = new HashMap<>();
		for(int i = 0; i < cityArray.length; i++)
		{
			distance.put(cityArray[i],Integer.MAX_VALUE);
		}
		
		distance.put(source, 0);
		PriorityQueue<SrcDistance> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.wt,b.wt));
		pq.add(new SrcDistance(source,0));
		
		while(!pq.isEmpty())
		{
			SrcDistance temp = pq.remove();
			String city = temp.Cname;
			int dist = temp.wt;
			
			for(Edge e : hm.get(city))
			{
				String nbrcityName = e.city_name;
				int way = e.distance;
				
				if( distance.get(nbrcityName) > distance.get(city) + way )
				{
					distance.put( nbrcityName, (distance.get(city) + way) );
					parent.put(nbrcityName, city);
					pq.add(new SrcDistance(nbrcityName, distance.get(nbrcityName)));
				}
				
			}
		}
		
		ArrayList<String> path = new ArrayList<>();
		path.add(destination);
		String copyOfDest = destination;
		while(parent.get(copyOfDest) != copyOfDest)
		{
			path.add(parent.get(copyOfDest));
			copyOfDest = parent.get(copyOfDest);
		}
		Collections.reverse(path);
		String ans = "";
		for(int i = 1; i < path.size(); i++)
		{
			if(i == path.size() - 1) ans += " " +path.get(i);
			else ans += " " + path.get(i) + " -> ";
		}
		return ans + "  Total =>  " + distance.get(destination) + " KM";
	}
}
