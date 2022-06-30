/**
 * 
 * Davina Phan
 * 1300285
 * COMP503
 * Assignment 2
 * 
 **/

package assignment;

abstract public class DigitalContent implements Comparable<DigitalContent>
{
	private String title;
	private String publisher;
	private String releaseDate;
	
	//constructor
	public DigitalContent(String title, String publisher, String releaseDate)
	{
		this.setTitle(title);
		this.setPublisher(publisher);
		this.setReleaseDate(releaseDate);
	}
	
	//toString method
	public String toString()
	{
		return "Title: " + this.title + " | Publisher: " + this.publisher + " | Release Date: " + this.releaseDate;
	}
	
	//query to see if it a string matches the title, publisher or release date
	public boolean match(String query)
	{			
		int length = query.length();
		String search = "";	
		String temp = "";
		boolean match = false;
		
		/**count where:
		 * first run time checks the title
		 * second run time checks the publisher
		 * third run time checks the release date
		 * */		
		for(int count = 0; count < 3; count++)
		{
			if(count == 0)
			{
				search = this.title;
			}
			else if(count == 1)
			{
				search = this.publisher;
			}
			else if(count == 2)
			{
				search = this.releaseDate;
			}
			
			//check if query string is longer than the result length
			//if query string is longer, then don't bother checking
			if(query.length() <= search.length())
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
			
			if(match == true)
			{
				break; //break out of the for loop when a match is found (no need to continue finding a match)
			}
		}
		
		return match;
	}
	
	//method for comparing the titles of two DigitalContent objects
	@Override
	public int compareTo(DigitalContent o) 
	{		
		return this.title.compareTo(o.title);
	}
	
	//get and set methods
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getPublisher() 
	{
		return publisher;
	}

	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}

	public String getReleaseDate() 
	{
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) 
	{
		this.releaseDate = releaseDate;
	}

	public static void main(String[] args) 
	{
		//testing
		/*DigitalContent test = new DigitalContent("title", "publisher", "2022");
		
		String test1 = "tle";
		String test2 = "uBli";
		String test3 = "22";
		String test4 = "abc";

		System.out.println(test.match(test1));
		System.out.println(test.match(test2));
		System.out.println(test.match(test3));
		System.out.println(test.match(test4));*/
	}
}
