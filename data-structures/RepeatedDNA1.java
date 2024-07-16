import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;



class RepeatedDNA1 {

	public static void findRepeatedSequences(String s, int k){
		// Since we have static map, switch it to number
		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put('A', 1);
		charMap.put('C', 2);
		charMap.put('G', 3);
		charMap.put('T', 4);

		int len = s.length();

		List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[len]));
		for(int i = 0; i<len; i++){
			numbers.set(i, charMap.get(s.charAt(i)));
		}

		int hashValue = 0;
		for(int i=0; i < k; i++) {
			hashValue += numbers.get(i) * Math.pow(4, k-i-1);
		}


		Set<Integer> hashValueSet = new HashSet<>();
		Set<String> repeatedString = new HashSet<>();
		hashValueSet.add(hashValue);


		for(int j=1; j + k <= len; j++) {
			int previousHashValue = hashValue;
			hashValue = ((previousHashValue - (numbers.get(j-1) * (int) Math.pow(4, k - 1)))*4) + numbers.get(j+k-1);

			if(hashValueSet.contains(hashValue)){
				repeatedString.add(s.substring(j, j+k));
			} else {
				hashValueSet.add(hashValue);
			}
		}

		System.out.println("The repeated strings are :" + repeatedString);

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