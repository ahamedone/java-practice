import java.util.Arrays;
import java.util.List;

class ReverseWords {

	private static void strRev(char[] str, int startRev, int endRev) {
		
		int start = startRev, end = endRev;

		while(start<end){
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

	private static String reverseWords(String str){
		if(str == null) return "";
		str = str.replace("\\s+","").trim();

		char[] charArray = str.toCharArray();
		int strLen = charArray.length - 1;

		strRev(charArray, 0, strLen);

		for(int start = 0, end = 0; end <= strLen; ++end) {
			if(end == strLen || charArray[end] == ' '){
				int endIndex = (end == strLen) ? end : end - 1;
				strRev(charArray, start, endIndex);
				start = end+1;
			}
		}

		return new String(charArray);
	}
	
	// Driver code
    public static void main(String[] args) {
        List<String> stringsToReverse = Arrays.asList(
            "Hello World",
            "a   string   with   multiple   spaces",
            "Case Sensitive Test 1234",
            "a 1 b 2 c 3 d 4 e 5",
            "     trailing spaces",
            "case test interesting an is this"
        );

        for (int i = 0; i < stringsToReverse.size(); i++) {
            System.out.println((i + 1) + ".\tOriginal string: '" + stringsToReverse.get(i) + "'");
            System.out.println("\tReversed string: '" + reverseWords(stringsToReverse.get(i)) + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}