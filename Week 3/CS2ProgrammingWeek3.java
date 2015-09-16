import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek3 
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
	//	Given a string and a non-empty substring sub, compute recursively if at 
	//	least n copies of sub appear in the string somewhere, possibly with 
	//	overlapping. N will be non-negative.

	//	subCopies("catcowcat", "cat", 2) → true
	//	subCopies("catcowcat", "cow", 2) → false
	//	subCopies("catcowcat", "cow", 1) → true
	
	/**
	 * 
	 * @param str, sub, n
	 * 		String str contains the original string to be tested against
	 * 		String sub contains the string that is used to test against str
	 * 		int n specifies how many copies of sub to check for
	 * 
	 * @return
	 * 		returns true if there are n copies of sub in str
	 * 		returns false if there are not n copies of sub in str
	 */
	static boolean subCopies(String str, String sub, int n) 
	{	
		// Variable to count sub in str
		int count;
		
		// If statement for base case, string is empty
		if (str.isEmpty())
		{
			return n == 0;
		}
		
		// If statement to check if substring is in string, subtracts count by 1 if true
		if (str.startsWith(sub))
		{
			count = n - 1;
		}
		else
		{
			count = n;
		}
		
		// Returns recursive call with string starting at next index
		return subCopies(str.substring(1), sub, count);
	}

	//	Problem #2
	//	Given a non-negative int n, return the sum of its digits recursively 
	//	(no loops). Note that mod (%) by 10 yields the rightmost 
	//	digit (126 % 10 is 6), while divide (/) by 10 removes the 
	//	rightmost digit (126 / 10 is 12).

	//	sumDigitsInNumber(126) → 9
	//	sumDigitsInNumber(49) → 13
	//	sumDigitsInNumber(12) → 3
	
	/**
	 * 
	 * @param n
	 * 		int n contains integer to deal with.
	 * 
	 * @return integer
	 * 		integer that is the sum of each digit in int n.
	 */
	static int sumDigitsInNumber(int n) 
	{
		// If statement for base case
		if (n <= 0)
		{
			return 0;
		}
		
		// Returns addition of rightmost digit and recursive call for digits left over
		return (n % 10) + sumDigitsInNumber(n / 10);
	}

	//	Problem #3
	//	Given base and n that are both 1 or more, compute recursively (no loops) 
	//	the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

	//	exponential(3, 1) → 3
	//	exponential(3, 2) → 9
	//	exponential(3, 3) → 27
	
	/**
	 * 
	 * @param base, n
	 * 		int base containing the base of the term
	 * 		int n containing the exponent of the term
	 * 
	 * @return integer
	 * 		integer that corresponds with equating base to the n power
	 */
	static int exponential(int base, int n) 
	{
		// Verifying input is 1 or more
		if (base < 1 && n < 1)
		{
			return 0;
		}
		
		// If statement for base case, anything to 0 power is 1
		if (n == 0)
		{
			return 1;
		}
		
		// Returns multiplication of base to recursive call with power minus 1
		return base * exponential(base, n - 1);
	}	

	//	Problem #4
	//	Given a string, compute recursively (no loops) a new string 
	//	where all the lowercase 'x' chars have been changed to 'y' chars. 

	//	changeXtoY("codex") → "codey"
	//	changeXtoY("xxhixx") → "yyhiyy"
	//	changeXtoY("xhixhix") → "yhiyhiy"
	
	/**
	 * 
	 * @param str
	 * 		String containing original string of chars to deal with
	 * 
	 * @return String
	 * 		String of characters where the lowercase x's have been changed to y's
	 */
	public static String changeXtoY(String str) 
	{
		if (str.equals("")) 
		{
			return str;
		}
		
		if (str.charAt(0) == 'x') 
		{
			return 'y' + changeXtoY(str.substring(1));
		}
		
		return str.charAt(0) + changeXtoY(str.substring(1));
	}
	
	//	Problem #5
	//	Given an array of ints, compute recursively if the array 
	//	contains a 6. We'll use the convention of considering only 
	//	the part of the array that begins at the given index. 
	//	In this way, a recursive call can pass index+1 to move down 
	//	the array. The initial call will pass in index as 0. 

	//	find6({1, 6, 4}, 0) → true
	//	find6({1, 4}, 0) → false
	//	find6({6}, 0) → true	
	
	/**
	 * 
	 * @param nums, index
	 * 		int[] list containing the original array of numbers
	 * 		int containing the position to start in nums
	 * 
	 * @return boolean
	 * 		returns true if a 6 is found in the array
	 * 		returns false if no 6 is found in the array
	 */
	static boolean find6(int[] nums, int index) 
	{
		// If statement to return true if a 6 is found
		if (nums[index] == 6)
		{
			return true;
		}
		
		// If statement to return false if end of array is reached with no 6 found
		if (index == nums.length - 1)
		{
			return false;
		}
		
		// Recursive call that passes in incremented index
		return find6(nums, index + 1);
	}
	
	//	Problem #6
	//	Given a string, compute recursively a new string where all 
	//	the adjacent chars are now separated by a "*".   

	//	insertAsterisk("hello") → "h*e*l*l*o"
	//	insertAsterisk("abc") → "a*b*c"
	//	insertAsterisk("ab") → "a*b"
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars
	 * 
	 * @return AbridgedList
	 * 		String with an asterisk between each char
	 */
	static String insertAsterisk(String str) 
	{
		//If statement for base case being an empty or 1 character string
		if (str.equals("") || str.length() < 2) 
		{
			return str;
		}
		
		// Return first character in string plus * and recursively call remaining string
		return str.charAt(0) + "*" + insertAsterisk(str.substring(1));
	}
	
	//	Problem #7
	//	We'll say that a "pair" in a string is two instances of 
	//	a char separated by a char. So "AxA" the A's make a pair. 
	//	Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for 
	//	A and 1 for x. Recursively compute the number of 
	//	pairs in the given string.  

	//	numberPairs("axa") → 1
	//	numberPairs("axax") → 2
	//	numberPairs("axbx") → 1
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars provided
	 * 
	 * @return 
	 * 		int with the number of pairs as defined above
	 */
	static int numberPairs(String str) 
	{
		// If statement for base case where string is empty or less than or equal to 2
		if (str.isEmpty() || str.length() <= 2)
		{
			return 0;
		}
		
		// If statement to see if character at index 0 matches character at index 2
		if (str.charAt(0) == str.charAt(2))
		{
			return numberPairs(str.substring(1)) + 1;
		}
		
		// Return recursive call to substring starting with next character
		return numberPairs(str.substring(1));
	}
	
	//	Problem #8
	//	Given a string, return recursively a "cleaned" string where 
	//	adjacent chars that are the same have been reduced 
	//	to a single char. So "yyzzza" yields "yza".  

	//	reduceChars("yyzzza") → "yza"
	//	reduceChars("abbbcdd") → "abcd"
	//	reduceChars("Hello") → "Helo"
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars
	 * 
	 * @return 
	 * 		String with all repeated, adjacent chars are removed
	 */
	static String reduceChars(String str) 
	{
		// If statement for base case being an empty or 1 character string
		if (str.isEmpty() || str.length() < 2)
		{
			return str;
		}
		
		// If statement to check if adjacent characters in string match
		// If so pass substring in to recursive call
		if(str.charAt(0) == str.charAt(1))
		{
			return reduceChars(str.substring(1));
		}
		
		// Return one instance of duplicated character and process recursive call on rest of string
		return str.charAt(0) + reduceChars(str.substring(1));
	}
	
	//	Problem #9
	//	Given a string, return true if it is a nesting of zero or more 
	//	pairs of parenthesis, like "(())" or "((()))". Suggestion: 
	//	check the first and last chars, and then recur on what's inside them.  

	//	nestedParens("(())") → true
	//	nestedParens("((()))") → true
	//	nestedParens("(((x))") → false
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars
	 * 
	 * @return 
	 * 		returns true if there are zero or more pairs of parenthesis
	 * 		returns false if there are not zero or more pairs of parenthesis
	 */
	static boolean nestedParens(String str) 
	{
		// If statement for base case, string is empty
		if (str.isEmpty())
		{
			return true;
		}
		
		// If statement to check opposite sides of string for pair of parenthesis
		// If so, return recursive call for substring minus two end characters
		if(str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
		{
			return nestedParens(str.substring(1, str.length() - 1));
		}
		
		// If pairs don't match, return false
		return false;
	}
	
	//	Problem #10

	//	Given a string and a non-empty substring sub, compute 
	//	recursively the largest substring which starts and 
	//	ends with sub and return its length.  

	//	subStrSub("catcowcat", "cat") → 9
	//	subStrSub("catcowcat", "cow") → 3
	//	subStrSub("cccatcowcatxx", "cat") → 9
	
	/**
	 * 
	 * @param str, sub
	 * 		String containing the original chars to be tested against
	 * 		String containing the original chars to test with
	 * 
	 * @return 
	 * 		integer containing the largest number of chars in string 
	 * 		that start and end with sub
	 */
	static int subStrSub(String str, String sub) 
	{
		// If statement for base case, string is empty
		if (str.isEmpty())
		{
			return 0;
		}
		
		// If statement to check if left side of string has substring, recursive call to move in
		if (!str.startsWith(sub))
		{
			return subStrSub(str.substring(1), sub);
		}
		
		// If statement to check if right side of string has substring, recursive call to move in
		if (!str.endsWith(sub))
		{
			return subStrSub(str.substring(0, str.length() - 1), sub);
		}
		
		// Returns final length of string
		return str.length();
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