class TheDuplicateNumber {
	
	public static void main(String[] args){
		int testArray[][] = new int[][]{
			{1,3,4,2,2},
			{1,1},
			{1,3,4,2,2},
			{1,3,6,2,7,3,5,4},
			{1,2,2}
		};

		for(int i=0; i<testArray.length; i++){
			System.out.println(printArray(testArray[i]) + " " + findDuplicate(testArray[i]));
		}
	}

	public static int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		while(true) {
			System.out.println("Slow :" + slow + " Fast :" + fast);
			slow = nums[slow];
			fast = nums[nums[fast]];

			if(slow == fast) break;
		}

		fast = 0;

		do {
			fast = nums[fast];
			slow = nums[slow];
		} while(fast != slow);

		return slow;
	}

	public static String printArray(int[] nums){
		StringBuilder stringBuilder = new StringBuilder("[");
		for(int i=0; i<nums.length; i++){
			if(i == nums.length-1){
				stringBuilder.append(nums[i]+"]");
			} else {
				stringBuilder.append(nums[i]+", ");
			}
		}

		return stringBuilder.toString();
	}
}