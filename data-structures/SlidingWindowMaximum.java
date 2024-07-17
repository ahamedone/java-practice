import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class SlidingWindowMaximum {

	public static List<Integer> cleanUp(int i, List<Integer> currentWindow, int[] nums) {

		while(!currentWindow.isEmpty() && nums[i] >= nums[currentWindow.get(currentWindow.size() - 1)]){
			currentWindow.remove(currentWindow.size() - 1);
		}
		return currentWindow;
	}

	public static int[] findMaxSlidingWindow(int nums[], int w){

		if(nums.length == 1){
			return nums;
		}

		List<Integer> currentWindow = new ArrayList<>();
		int[] output = new int[nums.length - w + 1];

		for(int i = 0; i < w; i++) {

			// clean the current window, remove all the elements which are less than or equal to nums[i]
			cleanUp(i, currentWindow, nums);

			currentWindow.add(i);

		}

		output[0] = nums[currentWindow.get(0)];

		for(int i = w; i < nums.length; i++){
			cleanUp(i, currentWindow, nums);
			if(!currentWindow.isEmpty() && currentWindow.get(0) <= (i - w)){
				currentWindow.remove(0);
			}
			currentWindow.add(i);
			output[i - w + 1] = nums[currentWindow.get(0)];
		}

		return output;

	}


	public static void main(String args[]) {
		int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 6};
		int [][] numLists = {
			{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
		    {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
			{1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
			{10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
			{4, 5, 6, 1, 2, 3},
			{9, 5, 3, 1, 6, 3},
			{2, 4, 6, 8, 10, 12, 14, 16},
			{-1, -1, -2, -4, -6, -7},
			{4, 4, 4, 4, 4, 4}
		};

		for (int i = 0; i < numLists.length; i++) {
			System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
			System.out.println("\tWindow size:\t" + windowSizes[i]);
			System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
			System.out.println();
		}
	}
}