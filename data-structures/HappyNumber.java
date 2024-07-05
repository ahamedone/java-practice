class HappyNumber {
	/**
	 * We use the following process to check if a given number is a happy number:
	 * Starting with the given number 𝑛, replace the number with the sum of the squares of its digits. 
	 * Repeat the process until:
	 * 	 The number equals 1, which will depict that the given number 𝑛 is a happy number.
	 *   The number enters a cycle, which will depict that the given number 𝑛 is not a happy number.
	*/

	public static boolean isHappyNumber(int number){
		int slowPointer = n;
		int fastPointer = sumOfSquaredDigits(n);

		while(fastPointer != 1 && slowPointer != fastPointer) {
			slowPointer = sumOfSquaredDigits(slowPointer);
			fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
		}

		return fastPointer == 1;
	}

	public static int sumOfSquaredDigits(int number) {
		int totalSum = 0;
		while(number > 0) {
			int digit = number % 10;
			totalSum += Math.pow(digit, 2);
		}
		return totalSum;
	} 

	public static void main(String args[]) {
    	int a[] = {1, 5, 19, 25, 7};
    	for (int i = 0; i < a.length; i++) {
      		System.out.println((i + 1) + ".\tInput Number: " + a[i]);
      		String output = isHappyNumber(a[i]) ? "True" : "False";
      
      		System.out.println("\n\tIs it a happy number? " + output);
      		System.out.println(new String(new char[100]).replace('\0', '-'));
    	}
  	}
}