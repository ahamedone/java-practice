class SortColors {

	public static int[] sortColors(int[] intArray){

		int start = 0, current =0, end = intArray.length-1;

		while(current<=end){
			int temp = intArray[current];
			if(temp==0){
				intArray[current] = intArray[start];
				intArray[start++] = temp;
				current++;
			} else if (temp==2){
				intArray[current] = intArray[end];
				intArray[end--] = temp;
			} else {
				current++;
			}
		}

		return intArray;

	}

	public static String arrayToString(int[] intArray) {
		StringBuilder st = new StringBuilder();
		for(int i=0;i<intArray.length;i++){
			st.append(intArray[i] + (i==intArray.length-1 ? "":", "));

		}

		return "[" + st.toString() + "]";
	}
	
	public static void main(String[] args) {
        int[][] inputs = {
            {0, 1, 0},
            {1, 1, 0, 2},
            {2, 1, 1, 0, 0},
            {2, 2, 2, 0, 1, 0},
            {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + arrayToString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + arrayToString(sortedColors));

            System.out.println("-".repeat(100));
        }
    }
}