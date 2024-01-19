package Arrays;

public class MaxSubArray {

        public int maxSubArray(int[] nums) {
            int cur_sum , max_sum=nums[0];
            cur_sum = max_sum;
            for(int i=1;i<=nums.length-1;i++){
                cur_sum = Math.max(nums[i],(cur_sum+nums[i]));
                max_sum = Math.max(cur_sum,max_sum);
            }
            return max_sum;

            /////////////////brute force
//            int n = nums.length;
//            int maxSum = Integer.MIN_VALUE;
//
//            // Consider all subarrays
//            for (int i = 0; i < n; i++) {
//                int currentSum = 0;
//
//                for (int j = i; j < n; j++) {
//                    // Calculate the sum of the current subarray [i, j]
//                    currentSum += nums[j];
//
//                    // Update maxSum if the currentSum is greater
//                    if (currentSum > maxSum) {
//                        maxSum = currentSum;
//                    }
//                }
//            }
//
//            return maxSum;
        }

    public static void main(String[] args) {
//        -2,1,-3,4,-1,2,1,-5,4
//        1,1,8,9,10
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-10,-20,1,-5,4}));
    }
}
