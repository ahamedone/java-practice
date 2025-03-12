class CircularArrayLoop {

	public static void main(String[] args){

		int input[][] = new int[][]{
			{1,3,-2,-4,1},
			{2,1,-1,-2},
			{5,4,-2,-1,3},
			{1,2,-3,3,4,7,1},
			{3,3,1,-1,2}
		};

		for(int i=0; i<input.length; i++){
			System.out.println(printArray(input[i]) + " : " + circularArrayLoop(input[i]));
		}

	}

	public static String printArray(int[] intArray){
		StringBuilder stringBuilder = new StringBuilder("[");
		for(int i=0; i<intArray.length; i++){
			if(i == intArray.length-1) {
				stringBuilder.append(intArray[i] + "]");
			} else {
				stringBuilder.append(intArray[i] + ", ");
			}
		}
		return stringBuilder.toString();
	}

	public static boolean circularArrayLoop(int[] nums) {
		int size = nums.length;
		for (int i = 0; i < size; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextStep(slow, nums[slow], size);

                if (isNotCycle(nums, forward, slow))
                    break;

                fast = nextStep(fast, nums[fast], size);

                if (isNotCycle(nums, forward, fast))
                    break;

                fast = nextStep(fast, nums[fast], size);

                if (isNotCycle(nums, forward, fast))
                    break;

                if (slow == fast)
                    return true;
            }
        }	
		return false;
	}

	public static int nextStep(int pointer, int nextPointer, int size) {
       int returnValue = (pointer + nextPointer) % size;
       if (returnValue < 0) {
           returnValue += size;
       }
       return returnValue;
   }
   
   public static boolean isNotCycle(int[] nums, boolean currentDirection, int position){
       boolean nextDirection = nums[position] > 0;
       return (nextDirection != currentDirection || nums[position] % nums.length == 0);

   }
}