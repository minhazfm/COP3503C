import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek1 
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

	// Directions: Return the number of even ints in the given 
	// array (The number '0' counts as an even number). 
	// Note: the % "mod" operator computes the remainder, 
	// e.g. 5 % 2 is 1. 

	// CountEvenNumbersInArray({2, 1, 2, 3, 4}) → 3
	// CountEvenNumbersInArray({2, 2, 0}) → 3
	// CountEvenNumbersInArray({1, 3, 5}) → 0
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		int with the number of even numbers in NumberList
	 */
	static int CountEvenNumbersInArray(int[] NumberList) 
	{
		int evenCount = 0;

		// For loop to traverse array and divide each value by 2 to see if remainder is 0, means it is even
		for (int i = 0; i < NumberList.length; i++)
		{
			if (NumberList[i] % 2 == 0)
			{
				evenCount++;
			}
		}

		return evenCount;
	}

	// Given an array of ints, return true if the array contains no 
	//   1's and no 3's.

	// LookForLucky13({0, 2, 4}) → true
	// LookForLucky13({1, 2, 3}) → false
	// LookForLucky13({1, 2, 4}) → false
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		returns false if there is a 1 or 3 in the list.
	 * 		returns true if there are no 1s or 3s in the list.
	 */
	static boolean LookForLucky13(int[] NumberList) 
	{
		int count = 0;

		// For loop to traverse array and increase count if 1 or 3 are found
		for (int i = 0; i < NumberList.length; i++)
		{
			if (NumberList[i] == 1 || NumberList[i] == 3)
			{
				count++;
			}
		}

		// If statement to return boolean value if 1 or 3 are found
		if (count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}	

	// Given arrays NumberList1 and NumberList2 of the same length, 
	//   for every element in NumberList1, consider the 
	//   corresponding element in NumberList2 (at the same index). 
	//   Return the count of the number of times that the two 
	//   elements differ by 2 or less, but are not equal. 

	// MatchUpLists({1, 2, 3}, {2, 3, 10}) → 2
	// MatchUpLists({1, 2, 3}, {2, 3, 5}) → 3
	// MatchUpLists({1, 2, 3}, {2, 3, 3}) → 2
	
	static int MatchUpLists(int[] NumberList1, int[] NumberList2) 
	{
		int differCount = 0;

		// For loop to traverse both arrays and check the difference and equality of each index value
		for (int i = 0; i < NumberList1.length; i++)
		{
			if ( (NumberList1[i] - NumberList2[i] >= -2 && NumberList1[i] - NumberList2[i] <= 2) && NumberList1[i] != NumberList2[i] )
			{
				differCount++;
			}
		}

		return differCount;
	}	

	// Given an array of ints, return true if the array 
	//   contains either 3 even or 3 odd values all next 
	//   to each other. 

	// ModThreeNumbers({2, 1, 3, 5}) → true
	// ModThreeNumbers({2, 1, 2, 5}) → false
	// ModThreeNumbers({2, 4, 2, 5}) → true
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		return true if there are three consecutive events
	 * 			or three consecutive odds
	 * 
	 * 		otherwise returns false
	 */
	public static boolean ModThreeNumbers(int[] NumberList) 
	{
		// For loop to traverse array and return true if three consecutive even or odd values are found
		for (int i = 0; i < NumberList.length - 2; i++)
		{
			if (NumberList[i] % 2 == 0 && NumberList[i+1] % 2 == 0 && NumberList[i+2] % 2 == 0)
			{
				return true;
			}

			if(NumberList[i] % 2 != 0 && NumberList[i+1] % 2 != 0 && NumberList[i+2] % 2 != 0)
			{
				return true;
			}
		}

		return false;
	}

	// Return the "centered" average of an array of ints, 
	//   which we'll say is the mean average of the values, 
	//   except ignoring the largest and smallest values in 
	//   the array. If there are multiple copies of the 
	//   smallest value, ignore just one copy, and likewise 
	//   for the largest value. Use int division to produce 
	//   the final average. You may assume that the array is 
	//   length 3 or more. 

	// FindCenteredAverage({1, 2, 3, 4, 100}) → 3
	// FindCenteredAverage({1, 1, 5, 5, 10, 8, 7}) → 5
	// FindCenteredAverage({-10, -4, -2, -4, -2, 0}) → -3	
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		Average of the list of numbers without the
	 * 		first of the lowest numbers and the last of the
	 * 		highest numbers.
	 */
	static int FindCenteredAverage(int[] NumberList) 
	{
		int smallestValue = NumberList[0];
		int largestValue = NumberList[0];
		int count = 0;
		int total = 0;
		int average = 0;

		// For loop to traverse array to find smallest and largest values, also to sum total and keep count
		for (int i = 0; i < NumberList.length; i++)
		{
			if (smallestValue > NumberList[i])
			{
				smallestValue = NumberList[i];
			}

			if (largestValue < NumberList[i])
			{
				largestValue = NumberList[i];
			}

			total = total + NumberList[i];
			count++;
		}

		// Subtract smallest and largest values from array from total
		total = total - smallestValue - largestValue;

		// Remove smallest and largest values from count
		count = count - 2;

		average = total / count;

		return average;
	}
	
	// Given an array of ints, return true if every 2 that 
	//   appears in the array is next to another 2. 

	// LookForTwoTwo({4, 2, 2, 3}) → true
	// LookForTwoTwo({2, 2, 4}) → true
	// LookForTwoTwo({2, 2, 4, 2}) → false
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		true if every 2 is adjacent to another 2
	 * 		otherwise false
	 */
	static boolean LookForTwoTwo(int[] NumberList) 
	{
		boolean outcome = false;
		
		// For loop to traverse array and nested if else statements to check the value, as well as surrounding values
		for (int i = 0; i < NumberList.length; i++)
		{
			if (i == 0)
			{
				if (NumberList[i] == 2 && NumberList[i+1] != 2)
				{
					return false;
				}
			}
			else if(i == NumberList.length - 1)
			{
				if (NumberList[i-1] != 2 && NumberList[i] == 2)
				{
					return false;
				}
			}
			else if (NumberList[i] == 2)
			{
				if (NumberList[i-1] == 2 || NumberList[i+1] == 2)
				{
					outcome = true;
				}
				else
				{
					return false;
				}
			}
		}

		return outcome;
	}
	
	///////////////////////////////////////////
	//
	// End of assignment code.
	//
	///////////////////////////////////////////
	
	public static void main(String[] args)
	{
		int[] testArray1 = {1, 23, 75, 47, 82, 101};
		System.out.println(CountEvenNumbersInArray(testArray1));

		int[] testArray2 = {1, 4, 3, 3, 1, 2, 2, 2, 47, 82, 56};
		System.out.println(LookForLucky13(testArray2));

		int[] testArray3a = {1, 4, 3, 3, 1, 2, 2, 2, 47, 82, 56};
		int[] testArray3b = {3, 7, 56, 5, 17, 20, 20, 45, 80, 74, 56};
		System.out.println(MatchUpLists(testArray3a,testArray3b));

		int[] testArray4 = {1, 4, 3, 2, 1, 48, 2, 87, 3, 2, 2};
		System.out.println("ModThreeNumbers: " + ModThreeNumbers(testArray4));

		int[] testArray5 = {1, 4, 3, 3, 1, 2, 2, 2, 47, 82, 56};
		System.out.println(FindCenteredAverage(testArray5));	

		int[] testArray6 = {1, 4, 3, 3, 1, 2, 2, 2, 47, 82, 56};
		System.out.println(LookForTwoTwo(testArray6));
	}
	
}
