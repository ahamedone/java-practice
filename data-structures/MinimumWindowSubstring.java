import java.util.Map;
import java.util.HashMap;

class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		if(null == t || null == s || t.isEmpty() || s.isEmpty() || s.length() < t.length()){
			return "";
		}

		Map<Character, Integer> reqFrequency = new HashMap<>();
		Map<Character, Integer> charFrequency = new HashMap<>();
		int leftIndex = -1;
		int rightIndex = -1;

		int minLength = Integer.MAX_VALUE;

		for(int i=0;i<t.length();i++) {
			char c = t.charAt(i);
			reqFrequency.put(c, reqFrequency.getOrDefault(c, 0)+1);
		}

		int left = 0;
		int distinctCharCount = reqFrequency.size();
		int count = 0;

		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			charFrequency.put(c, charFrequency.getOrDefault(c, 0)+1);

			if(reqFrequency.containsKey(c) && reqFrequency.get(c).equals(charFrequency.get(c))) {
				count++;
			}

			while(count == distinctCharCount) {
				if(i - left + 1 < minLength) {
					minLength = i - left + 1;
					leftIndex = left;
					rightIndex = i+1;
				}

				if(minLength == t.length()){
					return s.substring(leftIndex, rightIndex);
				}
				char leftChar = s.charAt(left);

				if(charFrequency.containsKey(leftChar)){
					charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
				}

				if(reqFrequency.containsKey(leftChar) && charFrequency.get(leftChar) < reqFrequency.get(leftChar)){
					count--;
				}

				left++;
			}
		}

		return s.substring(leftIndex, rightIndex);
	}

	// Driver code
    public static void main(String[] args) {
        String[] s = {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD", "NNNNNNNNNNNNNNNNNNNNNN"};
        String[] t = {"TN", "I", "ABC", "RK", "VDD", "N"};
        for (int i = 0; i < s.length; i++) {
            System.out.println((i + 1) + ".\ts: " + s[i] + "\n\tt: " + t[i] + "\n\tThe minimum substring containing " + t[i] + " is: " + minWindow(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        } 

    }
}