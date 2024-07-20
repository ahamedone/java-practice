import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;


class LongestRepeatingCharacter {

	public static int longestRepeatingCharacterReplacement(String str, int k) {

		char currentChar;
		int mostFreqChar = 0;
		int start = 0;
		int maxLength = 0;
		Map<Character, Integer> charInstanceCount = new HashMap<>();
		for(int end = 0; end<str.length(); end++){
			currentChar = str.charAt(end);
			charInstanceCount.put(currentChar, charInstanceCount.getOrDefault(currentChar, 0)+1);
			mostFreqChar = Math.max(mostFreqChar, charInstanceCount.get(currentChar));
			if(end - start + 1 - mostFreqChar > k) {
				charInstanceCount.put(str.charAt(start), charInstanceCount.get(str.charAt(start)) - 1);
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;

	}

	public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}