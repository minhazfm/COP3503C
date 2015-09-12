import java.util.Arrays;
import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2Week2 
{
	
	///////////////////////////////////////////
	//
	// Start of assignment code.
	//
	///////////////////////////////////////////
	
	/**
	 * Returns the last name, first name, and PID of the student.
	 * 
	 * This is required in order to get credit for the programming assignment.
	 */
	static String GetNameAndPID()
	{
		return( "Mohammad,Minhaz,3960194");
	}
	
	//	Problem #1
	// Directions: Return true if the array contains, somewhere,
	// three increasing consecutive numbers like ....4, 5, 6,... or
	// 23, 24, 25.

	//	FindThreeIncreasingNumbers({1, 4, 5, 6, 2}) â†’ true
	//	FindThreeIncreasingNumbers({1, 2, 3}) â†’ true
	//	FindThreeIncreasingNumbers({1, 2, 4}) â†’ false
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		returns true if there are three increasing consecutive numbers
	 * 		returns false if there are not three increasing consecutive numbers
	 */
	static boolean FindThreeIncreasingNumbers(int[] NumberList) 
	{
		// For loop that traverses array until third to last value
		for (int i = 0; i < NumberList.length - 2; i++)
		{
			// If statement that checks array to see if there are three increasing consecutive numbers
			if (NumberList[i] + 1 == NumberList[i+1] && NumberList[i+1] + 1 == NumberList[i+2])
			{
				return true;
			}
		}
		
		// Returns false if three increasing consecutive numbers are not found
		return false;
	}

	//	Problem #2
	//	For each multiple of 10 in the given array, change all the values 
	//	following it to be that multiple of 10, until encountering another 
	//	multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.

	//	multiplesOfTen({2, 10, 3, 4, 20, 5}) â†’ {2, 10, 10, 10, 20, 20}
	//	multiplesOfTen({10, 1, 20, 2}) â†’ {10, 10, 20, 20}
	//	multiplesOfTen({10, 1, 9, 20}) â†’ {10, 10, 10, 20}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return NumberList
	 * 		int[] list of the same numbers changed to multiples of
	 * 		ten as they are encountered.
	 */
	static int[] multiplesOfTen(int[] NumberList) 
	{
		// Variable to hold multiple of 10
		int numReplace = 0;
		
		// For loop to traverse the array
		for (int i = 0; i < NumberList.length; i++)
		{
			// If statement to find a multiple of ten and assign it to hold variable
			if (NumberList[i] % 10 == 0)
			{
				numReplace = NumberList[i];
			}
			// Else-If statement that overlooks first index if it is not a multiple of 10 and replaces
			// following values that are not multiples of 10 with value in hold variable
			else if (i != 0 && NumberList[i] % 10 != 0)
			{
				NumberList[i] = numReplace;
			}
		}
		
		// Returns modified array
		return NumberList;
	}	

	//	Problem #3
	//	We'll say that an element in an array is "alone" if there are 
	//	values before and after it, and those values are different 
	//	from it. Return a version of the given array where every instance 
	//	of the given value which is alone is replaced by whichever 
	//	value to its left or right is larger.

	//	CheckForAloneNumbers({1, 2, 3}, 2) â†’ {1, 3, 3}
	//	CheckForAloneNumbers({1, 2, 3, 2, 5, 2}, 2) â†’ {1, 3, 3, 5, 5, 2}
	//	CheckForAloneNumbers({3, 4}, 3) â†’ {3, 4}
	
	/**
	 * 
	 * @param NumberList, changingNumber
	 * 		int[] list containing some numbers.
	 * 		int value of the number that should change in the array.
	 * 
	 * @return NumberList
	 * 		int[] list of numbers where every occurrence of changingNumber
	 * 		has been replaced by the larger of its two neighbors.
	 */
	static int[] CheckForAloneNumbers(int[] NumberList, int changingNumber) 
	{
		// For loop to traverse the array
		for (int i = 0; i < NumberList.length; i++)
		{
			// If statement that checks element is not in the beginning or end of array, and
			// element matches passed in value
			if (i != 0 && i != NumberList.length - 1 && NumberList[i] == changingNumber)
			{	
				// If statement checking if value to right is larger, setting element as value
				if (NumberList[i] < NumberList[i+1])
				{
					NumberList[i] = NumberList[i+1];
				}
				
				// If statement checking if value to left is larger, setting element as value
				if (NumberList[i] < NumberList[i-1])
				{
					NumberList[i] = NumberList[i-1];
				}
			}
		}
		
		// Returns modified array
		return NumberList;
	}	

	//	Problem #4
	//	Return a version of the given array where each zero value in 
	//	the array is replaced by the largest odd value to the right 
	//	of the zero in the array. If there is no odd value to the 
	//	right of the zero, leave the zero as a zero. 

	//	ReplaceZerosWithLargestOdd({0, 5, 0, 3}) â†’ {5, 5, 3, 3}
	//	ReplaceZerosWithLargestOdd({0, 4, 0, 3}) â†’ {3, 4, 3, 3}
	//	ReplaceZerosWithLargestOdd({0, 1, 0}) â†’ {1, 1, 0}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return NumberList
	 * 		int[] list containing the numbers where the zeros have been
	 * 		replaced with the largest odd number to the right of them.
	 */
	public static int[] ReplaceZerosWithLargestOdd(int[] NumberList) 
	{
		// For loop to traverse the array
		for (int i = 0; i < NumberList.length; i++)
		{
			// If statement that checks if element is 0
			if (NumberList[i] == 0)
			{
				// Variable to hold largest odd value found
				int largestOdd = 0;
				
				// For loop to traverse list after 0 is found in an element
				for (int j = i; j < NumberList.length; j++)
				{
					// If statement that checks if element is odd and larger than current hold value, sets
					// largest odd number in hold variable
					if (NumberList[j] % 2 != 0 && NumberList[j] > largestOdd)
					{
						largestOdd = NumberList[j];
					}
				}
				
				// Replaces 0 value with largest odd number found to the right of 0
				NumberList[i] = largestOdd;
			}
		}
		
		// Returns modified array
		return NumberList;
	}
	
	//	Problem #5
	//	Given start and end numbers, return a new array containing 
	//	the sequence of integers from start up to but not including end, 
	//	so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number 
	//	will be greater or equal to the start number. 
	//	Note that a length-0 array is valid. 

	//	CreateIncreasingArray(5, 10) â†’ {5, 6, 7, 8, 9}
	//	CreateIncreasingArray(11, 18) â†’ {11, 12, 13, 14, 15, 16, 17}
	//	CreateIncreasingArray(1, 3) â†’ {1, 2}	
	
	/**
	 * 
	 * @param start, end
	 * 		Two integers stating the start and end of the sequence.
	 * 
	 * @return NumberList
	 * 		int [] containg numbers ranging from start to end
	 * 		in order from least to greatest.
	 */
	static int[] CreateIncreasingArray(int start, int end) 
	{
		// Initializes new array based on difference between end and start values
		int[] NumberList = new int[end - start];
		
		// For loop to traverse array until length is met
		for (int i = 0; i < NumberList.length; i++)
		{
			// If statement that begins array with start value
			if (i == 0)
			{
				NumberList[i] = start;
			}
			// Else statement that increases each element in the array by 1
			else
			{
				NumberList[i] = ++start;
			}
		}
		
		// Returns new array
		return NumberList;
	}
	
	//	Problem #6
	//	Given a non-empty array of ints, return a new array containing 
	//	the elements from the original array that come before the 
	//	first 4 in the original array. The original array will contain 
	//	at least one 4. Note that it is valid in java to create 
	//	an array of length 0.  

	//	CopyNumbersBeforeFour({1, 2, 4, 1}) â†’ {1, 2}
	//	CopyNumbersBeforeFour({3, 1, 4}) â†’ {3, 1}
	//	CopyNumbersBeforeFour({1, 4, 4}) â†’ {1}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return AbridgedList
	 * 		int[] list containing all the numbers that appeared
	 * 		before the first 4 in the array.
	 */
	static int[] CopyNumbersBeforeFour(int[] NumberList) 
	{
		// Counter variable
		int j = 0;
		
		// For loop to traverse the array
		for (int i = 0; i < NumberList.length; i++)
		{
			// If else statement that increases counter variable, until a 4 is found
			// For loop is then broken
			if (NumberList[i] != 4)
			{
				j++;
			}
			else
			{
				break;
			}
		}
		
		// Initializes new modified array to length of counter variable
		int[] AbridgedList = new int[j];
		
		// For loop that inputs values from original array to modified array, limited
		// by length of modified array
		for (int i = 0; i < AbridgedList.length; i++)
		{
			AbridgedList[i] = NumberList[i];
		}
		
		// Returns modified array
		return AbridgedList;
	}
	
	//	Problem #7
	//	Return an array that contains the exact same numbers as 
	//	the given array, but rearranged so that all the zeros 
	//	are grouped at the start of the array. The order of the 
	//	non-zero numbers does not matter. So {1, 0, 0, 1} becomes 
	//	{0 ,0, 1, 1}. You may modify and return the 
	//	given array or make a new array.  

	//	MoveZerosToFront({1, 0, 0, 1}) â†’ {0, 0, 1, 1}
	//	MoveZerosToFront({0, 1, 1, 0, 1}) â†’ {0, 0, 1, 1, 1}
	//	MoveZerosToFront({1, 0}) â†’ {0, 1}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return RearrangedList
	 * 		int[] list containing all the numbers from original
	 * 		list with the zeros moved to the front.
	 */
	static int[] MoveZerosToFront(int[] NumberList) 
	{
		// Variable to hold index position
		int arrayPosition = 0;
		
		// New, modified array with same length as original array
		int[] RearrangedList = new int[NumberList.length];
		
		// For loop to traverse original array
		for (int i = 0; i < NumberList.length; i++)
		{
			// If statement that finds and copies all zeros found in original array, to
			// the beginning of new, modified array
			if (NumberList[i] == 0)
			{
				RearrangedList[arrayPosition] = NumberList[i];
				arrayPosition++;
			}
		}
		
		// For loop that continues adding the rest of the values from the original array
		// to the end of the new, modified array
		for(int i = 0; i < NumberList.length; i++)
		{
			if (NumberList[i] != 0)
			{
				RearrangedList[arrayPosition] = NumberList[i];
				arrayPosition++;
			}
		}
		
		// Returns modified array
		return RearrangedList;
	}
	
	//	Problem #8
	//	Return an array that contains the exact same numbers as 
	//	the given array, but rearranged so that all the even numbers 
	//	come before all the odd numbers. Other than that, the 
	//	numbers can be in any order. You may modify and 
	//	return the given array, or make a new array.  

	//	EvenFrontOddBack({1, 0, 1, 0, 0, 1, 1}) â†’ {0, 0, 0, 1, 1, 1, 1}
	//	EvenFrontOddBack({3, 3, 2}) â†’ {2, 3, 3}
	//	EvenFrontOddBack({2, 2, 2}) â†’ {2, 2, 2}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return RearrangedList
	 * 		int[] list containing all the numbers from original
	 * 		list with the even numbers in the front and the
	 * 		odd numbers in the back.
	 */
	static int[] EvenFrontOddBack(int[] NumberList) 
	{
		// Variable to hold index position
		int arrayPosition = 0;
		
		// New, modified array with same length as original array
		int[] RearrangedList = new int[NumberList.length];
		
		// For loop to traverse the original array
		for (int i = 0; i < NumberList.length; i++)
		{
			// If statement that finds and copies all even numbers found in original array,
			// to the beginning of new, modified array
			if (NumberList[i] % 2 == 0)
			{
				RearrangedList[arrayPosition] = NumberList[i];
				arrayPosition++;
			}
		}
		
		// For loop that continues adding the rest of the values from the original array
		// to the end of the new, modified array
		for(int i = 0; i < NumberList.length; i++)
		{
			if (NumberList[i] % 2 != 0)
			{
				RearrangedList[arrayPosition] = NumberList[i];
				arrayPosition++;
			}
		}
		
		// Returns modified array
		return RearrangedList;
	}
	
	///////////////////////////////////////////
	//
	// End of assignment code.
	//
	///////////////////////////////////////////
	
	public static void main(String[] args)
	{
	
	}
	
}