// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // System.out.println(plus(2,3));   // 2 + 3
	    // System.out.println(plus(-2,-3));   // 2 + 3
	    // System.out.println(minus(-7,2));  // 7 - 2
   		// System.out.println(minus(2,-7));  // 2 - 7
   		// System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		// System.out.println(pow(5,3));      // 5^3
   		// System.out.println(pow(3,5));      // 3^5
   		// System.out.println(div(12,3));   // 12 / 3    
   		// System.out.println(div(5,5));    // 5 / 5  
   		// System.out.println(div(25,7));   // 25 / 7
   		// System.out.println(mod(25,7));   // 25 % 7
   		// System.out.println(mod(120,6));  // 120 % 6    
   		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
   		// System.out.println(sqrt(76123));
	}  

	public static int plus(int x1, int x2) {
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				x1--;
			}
		}
		
		return x1;
	}


	public static int minus(int x1, int x2) {
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				x1++;
			}
		}
		

		return x1;
	}

	public static int times(int x1, int x2) {
		int temp = x1;

		if (x2 == 0) return 0;

		if (x2 < 0) return times(x1, -x2);

		if (x2 > 0 ){
			for (int i = 0; i < x2 - 1; i++) {
				x1 = plus(x1, temp);
			}
		} 

		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int temp = x;

		if (n == 0 ) return 1;

		for (int i = 0; i < n - 1; i++) {
			x = times(x, temp);
		}

		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 0;

		while (minus(x1, x2) >= 0) {
			x1 = minus(x1, x2);
			count++;
		}

		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x1 == 0) return 0;
		int countDiv = div(x1, x2);

		return x1 - times(x2, countDiv);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int initialNumber = 1;

		while (times(initialNumber, initialNumber) < x) {
			initialNumber++;
		}

		if (x == times(initialNumber, initialNumber)) {
			return initialNumber;
		}

		return initialNumber - 1;
	}	  	  
}