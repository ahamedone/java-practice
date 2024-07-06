import java.util.Arrays;

class CircularLoop {

	public static boolean circularArrayLoop(int[] nums) {

		int size = nums.length;

		for(int i=0; i< size; i++){

			int slow = i, fast = i;
			boolean isForward = (nums[i] >= 0);

			while(true){
				slow = nextPointer(nums, slow, size);
				if(isNotCycle(nums, isForward, slow)){
					break;
				}
				fast = nextPointer(nums, fast, size);
				if(isNotCycle(nums, isForward, fast)){
					break;
				}
				fast = nextPointer(nums, fast, size);
				if(isNotCycle(nums, isForward, fast)){
					break;
				}

				if(slow == fast)
					return true;

			}
		}

		return false;
	}

	public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {
        boolean currDirection = nums[pointer] >= 0;

        if (prevDirection != currDirection || Math.abs(nums[pointer] % nums.length) == 0) {
            return true;
        }

        return false;
    }

	public static int nextPointer(int[] nums, int pointer, int size){
		int returnPointer = pointer + nums[pointer];
		returnPointer = returnPointer % size;
		if(returnPointer < 0){
			returnPointer += size;
		}
		return returnPointer;
	}
	
	// Driver code
    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}