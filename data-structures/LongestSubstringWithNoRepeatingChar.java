import java.util.Map;
import java.util.HashMap;

class LongestSubstringWithNoRepeatingChar {
	
	public static int findLongestSubstring(String s){

		int left = 0, right = 0, maxLongestSubstring = 0;

		Map<Character, Integer> charMap = new HashMap<>();

		for(; right < s.length(); right++){
			char c = s.charAt(right);
			if(charMap.containsKey(c) && charMap.get(c) >= left) { 
				left = charMap.get(c) + 1;
			} 
			int strLength = right - left + 1;
			maxLongestSubstring = Math.max(strLength, maxLongestSubstring);
			charMap.put(c, right);
		}
		return maxLongestSubstring;
	}

	// Driver code
    public static void main(String[] arg) {
        String[] inputs = {
            "abcabcbb",
            "pwwkew",
            "bbbbb",
            "ababababa",
            "",
            "ABCDEFGHI",
            "ABCDEDCBA",
            "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = findLongestSubstring(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}