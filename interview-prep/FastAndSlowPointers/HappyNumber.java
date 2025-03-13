class HappyNumber {
	public static void main(String[] args){
		int a[] = {1, 5, 19, 25, 7};
    	for (int i = 0; i < a.length; i++) {
      		System.out.println((i + 1) + ".\tInput Number: " + a[i]);
      		String output = isHappyNumber(a[i]) ? "True" : "False";
      
      		System.out.println("\n\tIs it a happy number? " + output);
      		System.out.println(new String(new char[100]).replace('\0', '-'));
    	}
	}

	public static boolean isHappyNumber(int n){
		int slowPointer = n;
		int fastPointer = sumOfSquaredDigits(n); 

		while(fastPointer != 1 && slowPointer != fastPointer){
			slowPointer = sumOfSquaredDigits(slowPointer); 
			fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer)); 
		}

		return fastPointer == 1;
	}

	public static int sumOfSquaredDigits(int n){
		int sum = 0;
		while(n > 0){
			int digit = n%10;
			sum += digit*digit;
			n = n/10;
		}
		return sum;
	}
}