import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class RepeatedDNA {

	public static void findRepeatedSequences(String s, int k){
		int n = s.length();
		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put('A', 1);
		charMap.put('C', 2);
		charMap.put('G', 3);
		charMap.put('T', 4);

		int a = 4; // base value since we have only 4 char in this DNA

		List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
		for(int i=0; i<n; i++){
			numbers.set(i, charMap.get(s.charAt(i)));
		}

		int hashValue = 0;

		Set<Integer> hashSet = new HashSet<>();
        Set<String> subStrings = new HashSet<>();

        for (int i = 0; i+k <= n; i++) {
        	if(i==0){
        		for (int j = 0; j < k; j++) {
        			hashValue += numbers.get(j) * (int) Math.pow(a, k - j - 1); 
        		}
        	} else {
        		int previousHashValue = hashValue;
        		hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(a, k - 1)) * a) + numbers.get(i + k - 1);
        	}

        	if(hashSet.contains(hashValue)){
        		subStrings.add(s.substring(i, i + k));
        	}

        	 hashSet.add(hashValue);
        }



	/*		
		List<String> subStrings = new ArrayList<>();
		Map<String, Integer> seen = new HashMap<>();
		for(int i=0; i+k<= s.length(); i++){
			String subString = s.substring(i, i+k);
			seen.put(subString, seen.getOrDefault(subString, 0)+1);
			if(seen.get(subString) == 2){
				subStrings.add(subString);
			}
		}
	*/
		System.out.println("The repeated strings are :" + subStrings);
	}


	public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) + 
                                         "\n\tk: " + inputsK.get(i) + "\n");
            findRepeatedSequences(inputsString.get(i), inputsK.get(i));
            System.out.println("-".repeat(100));
        }
    }

}
