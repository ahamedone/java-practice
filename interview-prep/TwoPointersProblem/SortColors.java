class SortColors {

	public static void main(String[] args){
		int[][] colorArrays = new int[][]{
							{1,0,2,1,2,2},
							{2,1,1,0,0},
							{1},
							{2},
							{0},
							{}
						};
		for(int i=0; i< colorArrays.length ; i++){
			System.out.println("Test Item " + i + " : " + printArrays(colorArrays[i]));
			System.out.println("Sort Item " + i + " : " + printArrays(sortColors(colorArrays[i])));
		}
	}

	public static int[] sortColors (int[] colors) {

		// Keep tracks of the left pointer and zero values
        int leftZero = 0;
        //Keeps tracks of the right pointer and value 2
        int rightTwo = colors.length-1;
        // nvaigational pointer.
        int pointer = 0;

        while(pointer <= rightTwo){
        	if(colors[pointer] == 0) {
        		colors[pointer++] = colors[leftZero];
        		colors[leftZero++] = 0;
        	} else if(colors[pointer] == 2){
        		colors[pointer] = colors[rightTwo];
        		colors[rightTwo--] = 2;
        	} else {
				pointer++;
        	}
        }
            
        return colors;
    }

    public static String printArrays(int intArray[]){
    	StringBuffer sb = new StringBuffer();
    	sb.append("[");
    	for(int i=0; i<intArray.length ; i++){
    		sb.append(intArray[i]);
    		if(i != intArray.length-1){
    			sb.append(", ");
    		}
    	}
    	sb.append("]");

    	return sb.toString();
    }
}