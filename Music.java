/**
 * 
 * Davina Phan
 * 1300285
 * COMP503
 * Assignment 2
 * 
 **/

package assignment;

public class Music extends DigitalContent
{
	private String artist;
	
	//constructor
	public Music(String title, String publisher, String releaseDate, String artist) 
	{
		super(title, publisher, releaseDate);
		this.setArtist(artist);
	}
	
	//toString method
	public String toString()
	{
		String str = super.toString();
		str += " | Artist: " + this.artist;
		
		return str;
	}
	
	//set the match method to check for artist as well
	@Override
	public boolean match(String query)
	{
		boolean match = false;
		int length = query.length();
		String search = this.artist;	
		String temp = "";
		
		if(super.match(query) == true)
		{
			match = true;
		}
		else if (query.length() <= search.length())//same function as the super's method
		{
			for(int i = 0; i < search.length(); i++)
			{
				temp = search.substring(i, length + i);
				
				if(temp.equalsIgnoreCase(query))
				{
					match = true;
					break; //this breaks out of the for loop
				}
				
				if((length + i) == search.length())
				{
					break; //stop the program from going past the boundary of the string
				}
			}				
		}
		
		return match;
	}

	//get and set methods
	public String getArtist() 
	{
		return artist;
	}

	public void setArtist(String artist) 
	{
		this.artist = artist;
	}

	public static void main(String[] args) 
	{
		//test
		/*Music song = new Music("Drawing our moments", "SM Town", "2020", "Kim Taeyeon");
		
		System.out.println(song);
		System.out.println(song.match("Yeon"));
		System.out.println(song.match("m t"));
		System.out.println(song.match("bye"));*/
	}
}
