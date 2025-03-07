import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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

    public static List<List<Integer>> threeSum(int[] nums) { // This functions overal time complexity is O(n^2). 
        // sort the arrays
        Arrays.sort(nums); // Arrays.sort() uses the variant of quicksort. Hence the average is O(n log n), with worse case scenario of O(n^2)

        // result List
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        for (int first = 0; first < n - 2; first++) { // loops run n-2 times, Hence O(n)

            // If an element is greater than 0, which means all the elements to the right too will be greater than the 1 and we can stop here.
            if(nums[first] > 0){
                break;
            }

            // If the current element and previous element are same, then we have a chance of getting the duplicate triplets, hence we skip the duplicate adjacent firsts
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first+1;
            int third = n-1;

            while(second < third){ // this while loops run O(n)
                int total = nums[first] + nums[second] + nums[third];
                if(total < 0){
                    // This means sum is not enough, so we increment the second element to a higher value, in the sorted array.
                    second++;
                } else if(total > 0){
                    // This means sum is more than zero, so we decrement the third element the next lower value, in the sorted array.
                    third--;
                } else {
                    // means sum is 0, add to the result set
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));

                    // shrink the array, to avoid the duplicate triplets.
                    second++; third--;
                    while (second < third && nums[second] == nums[second - 1]) { // this can too run O(n) times, however, this will reduce the runs require for the outerloop, hence can we left.
                        second++;
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                }
            }  
        }
        return result;
     }
}