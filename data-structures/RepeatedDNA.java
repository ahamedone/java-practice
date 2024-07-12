import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class RepeatedDNA {

	public static void findRepeatedSequences(String s, int k){
		List<String> subStrings = new ArrayList<>();
		Map<String, Integer> seen = new HashMap<>();
		for(int i=0; i+k<= s.length(); i++){
			String subString = s.substring(i, i+k);
			seen.put(subString, seen.getOrDefault(subString, 0)+1);
			if(seen.get(subString) == 2){
				subStrings.add(subString);
			}
		}

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
