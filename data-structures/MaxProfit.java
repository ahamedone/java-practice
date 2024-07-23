import java.util.Arrays;

class MaxProfit {
	
	public static int maxProfit(int[] prices){

		int maxProfit = 0;
		int left = 0, right = 1;

		while(right < prices.length){
			maxProfit = Math.max(maxProfit,prices[right] - prices[left]);
			if(prices[left] >= prices[right]){
				left = right;
			}
			right++;
		}
		return maxProfit;
	}

	public static void main(String[] args) {

		int[][] inputArr = {
            {10, 4, 11, 1, 5},
            {7, 7, 6, 6, 1, 6, 100},
            {4, 10, 5, 1, 6, 7},
            {4, 4, 4, 3, 3, 4}
        };

        for (int i = 0; i < inputArr.length; i++) {
        	int maxProfit = maxProfit(inputArr[i]);
        	System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
        	System.out.println("\n\tMaximum Profit: " + maxProfit);
        	System.out.println(new String(new char[100]).replace('\0', '-'));
        }
	}
}