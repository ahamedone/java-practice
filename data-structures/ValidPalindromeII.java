class ValidPalindromeII {

	public static boolean isPalindrome(String str){
		int left = 0, right = str.length()-1;
		char[] charArray = str.toCharArray();
		boolean usedOnce = false;

		while(left < right){
			if(charArray[left] == charArray[right]){
				left++;
				right--;
			} else {
				return (isValidPalindrome(charArray, left+1, right) || isValidPalindrome(charArray, left, right-1));
			}
		}

		return true;
	}

	public static boolean isValidPalindrome(char[] charArray, int left, int right) {
		while(left < right){
			if(charArray[left] == charArray[right]){
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] arg) {
    String[] testCase = {
      "RACEACAR",
      "A",
      "ABCDEFGFEDCBA",
      "ABC",
      "ABCBA",
      "ABBA",
      "RACEACAR"
    };
    for (int k = 0; k < testCase.length; k++) {
      System.out.println("Test Case #" + (k + 1));
      System.out.println(new String(new char[100]).replace('\0', '-'));
      System.out.println("The input string is " + testCase[k] + "' and the length of the string is " + testCase[k].length() + ".");
      System.out.println("\nIs it a palindrome?..... " + isPalindrome(testCase[k]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }

}