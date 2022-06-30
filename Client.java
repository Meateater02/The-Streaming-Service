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
import java.util.Scanner;

public class Client implements Play
{
	private StreamingService object;
	private DigitalContent currentlyStreamed;
	
	//constructor
	public Client(StreamingService object)
	{
		this.object = object;
		this.currentlyStreamed = null;
	}
	
	//implementing the methods declared in Play interface
	@Override
	public DigitalContent getCurrentStream() 
	{
		return this.currentlyStreamed;
	}
	
	@Override
	public void stream(String query) 
	{
		ArrayList<DigitalContent> matching = this.object.match(query);
		
		if(matching.size() != 0)
		{
			this.currentlyStreamed = matching.get(0);
		}
	}
	
	@Override
	public void stop() 
	{
		this.currentlyStreamed = null;
	}
	
	//get methods
	public StreamingService getObject() 
	{
		return this.object;
	}

	public DigitalContent getCurrentlyStreamed() 
	{
		return this.currentlyStreamed;
	}
	
	//main
	public static void main(String[] args) 
	{
		Client customer = new Client(new StreamingService());
		
		//add into customer
		customer.getObject().add(new Film("Frozen 2", "Walt Disney", "2019", "Idina Menzel"));
		customer.getObject().add(new Film("The Greatest Showman", "20th Century Studios", "2017", "Zac Efron, Zendaya, Hugh Jackman"));
		customer.getObject().add(new Film("Hamilton", "Walt Disney", "2020", "Lin-Manuel Miranda"));
		customer.getObject().add(new Film("The Lion King", "Walt Disney", "1994", "Jeremy Irons"));
		customer.getObject().add(new Film("The Man in the Iron Mask", "MGM Home Entertainment", "1998", "Leonardo DiCaprio"));
		customer.getObject().add(new Music("Drawing our moments", "SM Town", "2020", "Kim Taeyeon"));
		customer.getObject().add(new Music("Star Wind Flower Sun", "RBW", "2018", "Mamamoo"));
		customer.getObject().add(new Music("Eight", "Suga", "2020", "IU"));
		customer.getObject().add(new Music("Everyday Love", "SM Town", "2013", "Girl's Generation"));
		customer.getObject().add(new Music("Day by Day", "MBK Entertainment", "2012", "T-ara"));
		
		Scanner scan = new Scanner(System.in);
		
		boolean quit = false;
		String userAction = "";
		
		System.out.println("Welcome to the Media Player!\n");
		//note* changed the name of the app "client application" to "media player"
		
		while(quit == false)
		{
			System.out.println("Please select one of the following:");
			System.out.println("A. Display Digital Content library");
			System.out.println("B. Display currently streaming DigitalContent");
			System.out.println("C. Match Digital Content to Stream");
			System.out.println("D. Stop streaming");
			System.out.println("E. Quit Media Player");
			userAction = scan.nextLine();
			
			switch(userAction)
			{
			case "A": //fall through...
			case "a":
				System.out.println(customer.getObject());
				break;
			case "B": //fall through...
			case "b":
				if(customer.getCurrentlyStreamed() == null)
				{
					System.out.println("There is no media currently playing.\n");
				}
				else
				{
					System.out.println(customer.getCurrentlyStreamed() + "\n");					
				}
				break;
			case "C": //fall through...
			case "c":
				System.out.println("Please input a query to be streamed: ");
				userAction = scan.nextLine();
				customer.stream(userAction);
				if(customer.getCurrentStream() == null)
				{
					System.out.println("Unfortunately nothing matches your query. Please try again.\n");
				}
				else
				{
					System.out.println("Starting to stream...\nStreaming: " + customer.getCurrentStream() + "\n");
				}
				break;
			case "D":
			case "d":
				System.out.println("Stopping to stream:\n" + customer.getCurrentStream() + "\n");
				customer.stop();
				break;
			case "E": //fall through...
			case "e":
				quit = true;
				break;
			}
		}
		
		System.out.println("You have quit the media player. Goodbye!");
		
		scan.close();
	}
}
