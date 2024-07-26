import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class MergeIntervals {

	public static int[][] mergeIntervals(int[][] intervals){

		int[] currentInterval = new int[2];
		currentInterval[0] = intervals[0][0];
		currentInterval[1] = intervals[0][1];

		List<int[]> returnList = new ArrayList<>();
		returnList.add(currentInterval);

		for(int[] interval : intervals){
			if(currentInterval[1] >= interval[0]){
				currentInterval[1] = Math.max(currentInterval[1], interval[1]);
			} else {
				currentInterval = interval;
				returnList.add(currentInterval);
			}
		}
		return returnList.toArray(new int[returnList.size()][2]);
	}

	// Driver code
    public static void main(String[] args) {
        int[][][] allIntervals = {
                {{1, 5}, {3, 7}, {4, 6}},
                {{1, 5}, {4, 6}, {6, 8}, {11, 15}},
                {{3, 7}, {6, 8}, {10, 12}, {11, 15}},
                {{1, 5}},
                {{1, 9}, {3, 8}, {4, 4}},
                {{1, 2}, {3, 4}, {8, 8}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };
        
        int i = 0;
        for (int[][] intervals : allIntervals) {
            System.out.println(i+1+ ".\tIntervals to merge: " + Arrays.deepToString(intervals));
            int[][] result = mergeIntervals(intervals);
            System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
	
}