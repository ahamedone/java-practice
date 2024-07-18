class MinSubsequence {

	private static String minWindow(String str, String subStr){

		int strLen = str.length();
		int subStrLen = subStr.length();

		int start = 0, end = 0, strPtr = 0, subStrPtr = 0;
		int minSubLen = Integer.MAX_VALUE;
		String subString = new String();

		while(strPtr < strLen) {
			// System.out.println("strPtr : "+ strPtr + " subStrPtr : " + subStrPtr + " start : " + start + " end : " + end + " str.charAt(strPtr) : " + str.charAt(strPtr) + "subStr.charAt(subStrPtr) : " + subStr.charAt(subStrPtr));
			if(str.charAt(strPtr) == subStr.charAt(subStrPtr)){
				if(subStrPtr == 0){
					start = strPtr;
				}
				subStrPtr++;
				//System.out.println("subStrPtr > " + subStrPtr + " subStrLen : " + subStrLen);
				if(subStrPtr == subStrLen){
					end = strPtr;
					start = end;
					subStrPtr--;
					while(subStrPtr >= 0){
						if(str.charAt(start) == subStr.charAt(subStrPtr)){
							subStrPtr--;
						}
						start--;
					}
					start++;
					if(end - start + 1 < minSubLen){
						minSubLen = end - start + 1;
						subString = str.substring(start, end+1);
					}
					strPtr = start;
					subStrPtr = 0;
				}
			}
			strPtr++;
		}
		return subString;
	}
	
	public static void main(String[] args) {
        // Driver code
        String[] str1 = {
          "abcbdebdde", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta", "abcdedeaqdweq"
        };
        String[] str2 = {
          "bde", "kzed", "css", "la", "ab", "aqeq"
        };


        for (int i = 0; i < str1.length; i++) {
          System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
          System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
          System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}