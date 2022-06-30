/**
 * 
 * Davina Phan
 * 1300285
 * COMP503
 * Assignment 2
 * 
 **/

package assignment;

public interface Play 
{
	public DigitalContent getCurrentStream();
	public void stream(String query);
	public void stop();
}
