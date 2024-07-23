import java.util.Arrays;

class MinimumSubArraySum {
	public static int minSubArrayLen(int target, int[] nums) {
		int windowSize = Integer.MAX_VALUE;
		int currSubArraySize = 0;
		int start = 0;
		int right= 0;
		int sum=0;

		for(;right<nums.length;right++){
			sum += nums[right];
			while(sum >= target){
				currSubArraySize = right - start + 1;
				windowSize = Math.min(currSubArraySize, windowSize);
				sum -= nums[start++];
			}
		}

		return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
	}

	// Driver code
    public static void main(String[] args) {
        int[] target = {7, 4, 11, 10, 5, 15};
        int[][] inputArr = {
            {2, 3, 1, 2, 4, 3},
            {1, 4, 4},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4},
            {1, 2, 1, 3},
            {5, 4, 9, 8, 11, 3, 7, 12, 15, 44}
        };
        for (int i = 0; i < target.length; i++) {
            int windowSize = minSubArrayLen(target[i], inputArr[i]);
            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
            System.out.print("\n\tTarget: " + target[i]);
            System.out.println("\n\tMinimum Length of Subarray: " + windowSize);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}