/**
 * 
 * Davina Phan
 * 1300285
 * COMP503
 * Assignment 2
 * 
 **/

package assignment;

public class Film extends DigitalContent
{
	private String castMembers;
	
	//constructor
	public Film(String title, String publisher, String releaseDate, String castMembers) 
	{
		super(title, publisher, releaseDate);
		this.setCastMembers(castMembers);
	}

	//toString method
	public String toString()
	{
		String str = super.toString();
		str += " | Cast Members: " + this.castMembers;
		
		return str;
	}
	
	//set the match method to check for cast members as well
	@Override
	public boolean match(String query)
	{
		boolean match = false;
		int length = query.length();
		String search = this.castMembers;	
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
	public String getCastMembers() 
	{
		return castMembers;
	}

	public void setCastMembers(String castMembers) 
	{
		this.castMembers = castMembers;
	}

	public static void main(String[] args) 
	{
		//testing
		/*Film movie = new Film("Frozen", "Disney", "2013", "Idina Menzel");
		
		System.out.println(movie);
		System.out.println(movie.match("Zel"));
		System.out.println(movie.match("013"));*/
	}
}
