package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        A:
//        for (int i = 0; i < nums.length; i++) {
//            B:
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    System.out.println(i + "  " + j);
//                    res[0] = i+1;
//                    res[1] = j+1;
//                    break A;
//                }
//            }
//        }
//        return res;

        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//int t= m+n-1;int j=nums2.length-1;
//        for(int i=m-1;i>=0;){
//            for(;j>=0 && i>=0;){
//                if(nums2[j]>=nums1[i]){
//                    nums1[t]=nums2[j];
//                    j--;
//                    t--;
//                }
//                else if(nums2[j]<nums1[i]){
//                    nums1[t]=nums1[i];
//                    i--;
//                    t--;
//                }
//            }
//            while (i>=0){
//                nums1[t]=nums1[i];
//                i--;
//                t--;
//            }
//
//        }
//        while (j>=0){
//            nums1[t]=nums2[j];
//            j--;
//            t--;
//        }
//
//        if(m==0){
//          nums1[0]=nums2[0];
//        }

        int i = m - 1, j = n - 1, t = m + n - 1;
        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[t--] = nums1[i--];
            }
            else{
                nums1[t--] = nums2[j--];
            }
        }

        for(int k=nums1.length-1;k>=0;k--){
            System.out.println(nums1[k]);
        }
    }


    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{2,7,11,15},17);
//        Arrays.stream(arr).forEach(System.out::println);
//        merge(new int[]{1,0},1,new int[]{2},1);
    }
}

