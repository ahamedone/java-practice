class SumOfThreeValues {
    
    public static void main(String[] param){
        int[][] testCases = {
            {-1, 0, 1, 2, -1, -4},
            {1, 2, 3, 4, 5},
            {0, 0, 0, 0},
            {-4, -1, -1, 0, 1, 2, 2},
            {-10, -7, -3, -1, 0, 3, 7, 10},
            {-3, -5, -7, -9}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("\nTest Case " + (i + 1) + ":\n\tInput: " + Arrays.toString(nums));
            List<List<Integer>> result = threeSum(nums);
            System.out.print("\tOutput: ");
            System.out.println(result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        } 
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        for (int pivot = 0; pivot < n - 2; pivot++) {
            if(nums[pivot] > 0){
                break;
            }
            
        }
     }
}