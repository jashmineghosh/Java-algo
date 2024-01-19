package Arrays;

public class RotateArray {
//    public void rotate(int[] nums, int k) {
//        int temp = 0;
//        if (nums.length > 1) {
//            while (k > 0) {
//                temp = nums[0];
//                nums[0] = nums[nums.length - 1];
//                reverse(temp, nums);
//                k--;
//            }
//        }
//    }
//
//
//    public static void reverse(int temp, int[] nums){
//        int temp1=0;
//       int i= nums.length-2;
//            while(i>0){
//
//            nums[nums.length-1-temp1] =  nums[i--];
//            temp1++;
//        }
//            nums[1]=temp;
//    }

    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums, 0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
//        -2,1,-3,4,-1,2,1,-5,4
//        1,1,8,9,10
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
