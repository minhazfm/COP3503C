//Name: Minhaz Mohammad
//Course Number: COP3503C
//Section: 0001
//Assignment: Lottery.java
//Date: September 2, 2015

import java.io.*;
import java.util.*;

public class lottery {
	
	// Enumeration method that holds constants for how many matches correlate to how much in winnings
	public enum PayOut 
	{
		MATCHNA(0), MATCHTHREE(10), MATCHFOUR(100), MATCHFIVE(10000), MATCHSIX(1000000);
			
		private int winnings;
		
		// Methods to get corresponding winnings value
		public int getval()
		{
			return winnings;
		}
		
		private PayOut(int amount)
		{
			this.winnings = amount;
		}
	}
	
	// Method call to create linked list with purchaser's data in each node
	static LinkedList<PurchaserList> purchasers = new LinkedList<>();
	
	// Data structure for purchaser information, contained in each node in linked list
	public static class PurchaserList
	{
		// Setting necessary data values for each purchaser
		public String lastName;
	    public String firstName;
	    public int[] numbers;
	   
	    public PurchaserList (String last, String first, int[] nums)
	    {
	        lastName = last;
	        firstName = first;
	        numbers = nums;
	    }
	    
	    public String getLastName()
	    {
	    	return lastName;
	    }
	    
	    public String getFirstName()
	    {
	    	return firstName;
	    }
	    
	    public int[] getNumbers()
	    {
	    	return numbers;
	    }
	}
	
	// Method to open and read in data from input file
	public static void ReadFile (String file) throws IOException
	{
		File fileName = new File(file);
	    	try
	        {
	    		Scanner in = new Scanner(fileName);
	    		
	    		// Taking first integer as amount of tickets
	    		int numTickets = in.nextInt();
	    		
	    		// For loop to input purchaser's last and first name
	            for(int i = 0; i < numTickets; i++)
	            {
	               String lastName = in.next();
	               String firstName = in.next();
	              
	               int[] numbers = new int[6];

	               // Nested for loop to create array for each purchaser's numbers
	               for(int j = 0; j < 6; j++)
	               {
	                    numbers[j] = in.nextInt();
	               }
	              
	               // Creates new instance/node in linked list for every purchaser and their data
	               PurchaserList current = new PurchaserList(lastName, firstName, numbers);
	               purchasers.add(i, current);
	            }
	           
	           // Close file
	           in.close();
	        }
	    	
	    	// If file is not found, catch error and terminate program
	    	catch (FileNotFoundException error)
	        {
	            System.out.printf("%nThe file does not exist, this program will now end.%n");
	            System.exit(0);
	        }
	}
	
	// Method to compare purchaser's numbers against winning numbers
	public static void CompareNumbers(int[] winningNumbers)
	{
        // Creates array to hold winning numbers
        List<Integer> winningNums = new ArrayList<>(); //creates a list to store all the winning numbers
        
        // For loop to store winning numbers in prior array
        for(int num : winningNumbers)
        {
            winningNums.add(num);
        }
       
        //For loop to go through each purchaser in the linked list and get their lottery numbers
        for (PurchaserList purchaser : purchasers)
        {
        	// Generating list that stores all the numbers from the current purchaser
        	List<Integer> purchaserNums = new ArrayList<>();
           
        	// For loop to add numbers to the list
        	for(int num : purchaser.getNumbers())
        	{
        		purchaserNums.add(num);
        	}
           
        	//Converts list in to a set
        	Set<Integer> similar = new HashSet<>(purchaserNums);
            
        	//Compares set of winning numbers to purchaser's numbers, keeps similar values
        	similar.retainAll(winningNums);
            
        	//Calls matches method to check number of similar values against PayOut, assigns to new method
        	PayOut matchesFound = matches(similar.size());
           
        	//Only display winnings if matches are 3 or greater
        	if(matchesFound != null)
        	{
        		Display(matchesFound, purchaser.getFirstName(), purchaser.getLastName(), similar.size());
        	}
        }
       
    }
	
	// Method to assign amount of matched number to corresponding winnings
    public static PayOut matches(int num)
    {
        PayOut numMatches;
    
        // If else statements to set match values to corresponding winnings in enumeration
        if(num == 3)
        {
            numMatches = PayOut.MATCHTHREE;
        }
       
        else if(num == 4)
        {
            numMatches = PayOut.MATCHFOUR;
        }
       
        else if(num == 5)
        {
            numMatches = PayOut.MATCHFIVE;
        }
       
        else if(num == 6)
        {
            numMatches = PayOut.MATCHSIX;
        }
       
        else
        {
        	numMatches = PayOut.MATCHNA;
        }
        
        return numMatches;
    }
 
    // Method to display results based on numbers matched and corresponding enumeration values
    private static void Display(PayOut numMatches, String first, String last, int matches)
    {
    	// Switch statement to print purchaser's information, numbers matched and winnings
        switch(numMatches)
        {
            case MATCHTHREE:
                System.out.printf("%n%s %s matched %d numbers and won $%d. %n", first, last, matches, PayOut.MATCHTHREE.getval());
                break;

            case MATCHFOUR:
                System.out.printf("%n%s %s matched %d numbers and won $%d. %n", first, last, matches, PayOut.MATCHFOUR.getval()); 
                break;

            case MATCHFIVE:
                System.out.printf("%n%s %s matched %d numbers and won $%d. %n", first, last, matches, PayOut.MATCHFIVE.getval());
                break;

            case MATCHSIX:
                System.out.printf("%n%s %s matched %d numbers and won $%d. %n", first, last, matches, PayOut.MATCHSIX.getval());
                break;

            default:
                System.out.printf("%nNo one matched enough numbers to win anything. %n");
                break;
        }
    }

    // Method to check winning lottery numbers at input to see if they are ascending and in range
	static boolean CheckNumbers (int arr[]) 
	{
		boolean outcome = false;
		
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i - 1] < arr[i])
			{
				outcome = false;
			}
			else
			{
				return true;
			}
	    
			if(arr[i] >= 1 && arr[i] <= 53)
			{
				outcome = false;
			}
			else
			{
				return true;
			}
		}
	  
		return outcome;
	}

	// Main method
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);

		// Asking user for input file
		System.out.printf("Enter the name of the file with the ticket data: %n");
		
		// Take file name as a string
		String fileName = scan.nextLine();
		
		//Method call to open and read in data from input file
		ReadFile(fileName);
     
		// Creates array to store winning lottery numbers
		int[] winningNumbers = new int[6];
      
		// Asking user for winning lottery numbers, in ascending order
		System.out.printf("%nEnter the winning Lottery numbers (in ascending order separated by spaces): %n");

		// For loop to scan in winning lottery numbers to array
		for(int i = 0; i < 6; i++)
		{
			winningNumbers[i] = scan.nextInt();
		}
		
		// If statement to check boolean value when testing winning lottery number input
		if(CheckNumbers(winningNumbers))
		{
			System.out.printf("%nThe winning lottery numbers have to be in ascending order and between 1 and 53, please try again.%n");
		}
		else
		{
			//Method call to compare winning numbers to purchaser's numbers
			CompareNumbers(winningNumbers);
		}

		// Close input file
		scan.close();
	 }
	
}