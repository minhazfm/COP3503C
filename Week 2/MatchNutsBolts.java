//Name: Minhaz Mohammad
//Course Number: COP3503C
//Section: 0001
//Assignment: MatchNutsBolts.java
//Date: September 9, 2015

import java.util.*;

public class MatchNutsBolts {

	// Method for nut and bolt arrays to be passed in
	public static void match(Nut[] nuts, Bolt[] bolts)
	{
		// Variables for lo and hi readings
		int lo = 0;
		int hi = bolts.length - 1;
		
		// Passing necessary parameters in to method needed to start Quick Sort
		matchNB(bolts, nuts, lo, hi);
	}
	
	// Method that calculates pivot and calls Quick Sort
	public static void matchNB(Bolt[] bolts, Nut[] nuts, int lo, int hi)
	{
		if (lo < hi)
		{
			// Method call to quickSortNuts to partition the nuts array based on the bolts array
			// Returns value of pivot for the nuts
			int pivot = quickSortNuts(nuts, bolts, lo, hi);

			// Method call to partition the bolts array based on the nuts array
			quickSortBolts(bolts, nuts, lo, hi, pivot);

			// Recursively calls match for bolts and nuts arrays
			matchNB(bolts, nuts, lo, pivot - 1);
			matchNB(bolts, nuts, pivot + 1, hi);
		}
	}
	
    // Method that uses Quick Sort to arrange nuts based on bolts pivot, returns pivot for nuts
	public static int quickSortNuts(Nut[] nuts, Bolt[] bolts, int lo, int hi)
    {
    	// Set variable equal to low
        int i = lo;
        
        // Setting pivot based on bolt array
        Bolt pivotBolt = bolts[hi];
        
        // For loop that compares the nuts array to the pivot from bolts
        for (int j = lo; j < hi; j++)
        {
        	// If current nut is smaller than pivot bolt, swap values, else if
        	// they match, move current nut to the right
        	if (nuts[j].compareTo(pivotBolt) < 0)
        	{
        		swapNuts(nuts, i, j);
        		i++;
        	}
        	else if (nuts[j].compareTo(pivotBolt) == 0)
        	{
        		swapNuts(nuts, j, hi);
        		j--;
        	}
        }
        
        // Exchange values in nuts array
        swapNuts(nuts, i, hi);
        
        // Returns pivot value for the nuts
        return i;
    }

    // Method to swap nuts
	public static void swapNuts(Nut[] arr, int i, int j)
    {
    	Nut temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }

    // Method that uses QuickSort to arrange bolts based on nuts pivot
	public static void quickSortBolts(Bolt[] bolts, Nut[] nuts, int lo, int hi, int pivotNut)
    {
    	// Set variable equal to low
        int i = lo;
        
        // For loop that compares the bolts array to the pivot from nut
        for (int j = lo; j < hi; j++)
        {
        	// If current bolt is smaller than pivot nut. swap values, else if
        	// they match, move current bolt to right
        	if (bolts[j].compareTo(nuts[pivotNut]) < 0)
        	{
        		swapBolts(bolts, i, j);
        		i++;
        	}
        	else if (bolts[j].compareTo(nuts[pivotNut]) == 0)
        	{
        		swapBolts(bolts, j, hi);
        		j--;
        	}
        }
        
        // Exchange values in bolts array
        swapBolts(bolts, i, hi);
    }

    // Method to swap bolts
	public static void swapBolts(Bolt[] arr, int i, int j)
    {
    	Bolt temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }

    // Main method
    public static void main(String[] args)
    {   
    	// Had prior method calls here to test code, cleared them out so testing and grading
    	// can be completed
    }
}
