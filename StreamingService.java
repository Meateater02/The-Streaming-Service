/**
 * 
 * Davina Phan
 * 1300285
 * COMP503
 * Assignment 2
 * 
 **/

package assignment;

import java.util.ArrayList;
import java.util.Collections;

public class StreamingService 
{
	private ArrayList<DigitalContent> digitalArray;
	
	//constructor
	public StreamingService()
	{
		this.digitalArray = new ArrayList<DigitalContent>();
	}
	
	//toString method
	public String toString()
	{
		//sort the array to print out alphabetically by title
		Collections.sort(this.digitalArray);

		String str = "";
		
		for(DigitalContent digitalObject : digitalArray)
		{
			str += digitalObject + "\n";
		}
		
		return str;
	}
	
	//add method
	public void add(DigitalContent object)
	{
		if(object != null) //checks that the object isn't empty
		{
			this.digitalArray.add(object);			
		}
	}
	
	//match method that returns all the objects that matches the query
	ArrayList<DigitalContent> match(String query)
	{
		int size = this.digitalArray.size();
		DigitalContent temp;
		
		//declaring an arrayList that is to be returned
		ArrayList<DigitalContent> matchingList = new ArrayList<DigitalContent>();
		
		for(int i = 0; i < size; i++)
		{
			temp = this.digitalArray.get(i);
			
			if(temp.match(query) == true)
			{
				matchingList.add(temp);
			}
		}
		
		return matchingList;
	}

	public static void main(String[] args) 
	{
		//test
		/*StreamingService test = new StreamingService();
		
		DigitalContent frozen2 = new Film("Frozen 2", "Disney", "2013", "Idina Menzel");
		DigitalContent song2 = new Music("Star Wind Flower Sun", "RBW", "2018", "Mamamoo");
		DigitalContent tangled = new Film("Tangled", "Disney", "2010", "Mandy Moore");
		DigitalContent song = new Music("Drawing our moments", "SM Town", "2020", "Kim Taeyeon");
		
		test.add(frozen2);
		test.add(song);
		test.add(tangled);
		test.add(song2);
		
		System.out.println(test);
		System.out.println(test.match("201"));
		//the match prints out in the default form cause it's not StreamingService class
		//the toString method defined above only works if it's a StreamingService class
		
		//to print out like the toString method defined in this class, then:
		ArrayList<DigitalContent> matching = test.match("201");
		
		String str = "";
		for(DigitalContent match : matching)
		{
			str += match + "\n";
		}
		
		System.out.println(str);*/
	}
}
