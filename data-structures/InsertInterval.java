import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class InsertInterval {
	
	public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval){

		int begin = newInterval[0];
		int end = newInterval[1];

		List<int[]> outputList = new ArrayList<>();

		int pointer=0;
		int length = existingIntervals.length;

		while(pointer < length && existingIntervals[pointer][0] < begin){
			outputList.add(existingIntervals[pointer++]);
		}

		if(outputList.size()==0 || outputList.get(outputList.size() - 1)[1] < begin){
			outputList.add(newInterval);
		} else {
			int[] lastArray = outputList.get(outputList.size() - 1);
			lastArray[1] = Math.max(lastArray[1], newInterval[1]);
		}

		while(pointer < length) {
			int[] lastArray = outputList.get(outputList.size() - 1);
			int[] existingArray = existingIntervals[pointer];
			if(lastArray[1] < existingArray[0]){
				outputList.add(existingArray);
			} else {
				lastArray[1] = Math.max(lastArray[1], existingArray[1]);
			}
			pointer++;
		}

		return outputList.toArray(new int[0][0]);

	}


	// Driver code
    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}