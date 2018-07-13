import java.util.Scanner;

// Java program to print the Palindrome Family : PARENT | TWIN | ODD | EVEN | ALIEN (none)
// corresponding to a given string

public class palindromeFamily {

	// Checks if the given string is a Palindrome
	public static boolean isPalindrome(String str) {

		// Set two pointers, one at the last character of the string and
		// other the first character. If both of them don't match, then
		// it is not a palindrome. Keep incrementing start pointer,
		// and decreasing end pointer by one, until they check the middle character
    
		int start = 0, end = str.length() - 1;
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// Prints the Palindrome Family corresponding to a given string:
	public static void palindromeFamily(String str) 
   {

		// Check for parent palindrome:
		if (isPalindrome(str)) {
			System.out.println("PARENT Palindrome");
			return;
		}

		// Check for odd and even palindromes
		String oddString = "";
		String evenString = "";

		for (int i = 0; i < str.length(); i += 2) {
			oddString += str.charAt(i);
		}
		
		for (int i = 1; i < str.length(); i += 2) {
			evenString += str.charAt(i);
		}

		// Check if the individual evenString and oddString are palindrome
		boolean isEvenPalindrome = isPalindrome(evenString);
		boolean isOddPalindrome = isPalindrome(oddString);

		// Check if both oddString and evenString are palindromes
		// If yes, then it is a twin palindrome
		if (isOddPalindrome && isEvenPalindrome) {
			System.out.println("TWIN Palindrome");
		}
    
		// Else, check if odd indices form a palindrome
		else if (isOddPalindrome) {
			System.out.println("ODD Palindrome");
		}
    
		// Else, check if even indices form a palindrome
		else if (isEvenPalindrome) {
			System.out.println("EVEN Palindrome");
		}
    
		// If none of the cases satisfy, then it is an ALIEN palindrome
		else
			System.out.println("ALIEN Palindrome");

	}

	public static void main(String[] args) {
		StringBuffer sbuffer = new StringBuffer();
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt(); // test cases
		for (int i = 0; i < t; i++) {
			String s = sc.next();
			sbuffer.append(s);
			palindromeFamily(s);
		}
	}

}
