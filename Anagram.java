/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = removeSpaces(str1);
		str2 = removeSpaces(str2);

		if(str1.length() != str2.length()) return false;

		int count = 0;

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str1.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)){
					str2 = str2.substring(0, j) + " " + str2.substring(j+1);
					count++;
				}
			}
		}

		if (count == str1.length()) return true;

		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";

		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) - 0) > 64 || (str.charAt(i) - 0) == 32) {
				if ((str.charAt(i) - 0) > 90 || (str.charAt(i) - 0) == 32) newStr = newStr + str.charAt(i);
				else newStr = newStr + (char) (str.charAt(i) + 32);
			} 

				
		}

		return newStr;
	} 

	public static String removeSpaces(String str) {
		String newStr = "";

		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) - 0) != 32){
				if ((str.charAt(i) - 0) > 90) newStr = newStr + str.charAt(i);
				else newStr = newStr + (char) (str.charAt(i) + 32);
			}
		}

		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr = "";

		int r;

		int i = 0;
		int strLength = str.length();

		while (i < strLength) {
			r = (int) (Math.random() * str.length());
			newStr += str.charAt(r);

			str = str.substring(0, r) + str.substring(r+1);
			i++;
		}

		return newStr;
	}
}
