package FSD_Basic;

import java.util.*;
import java.util.stream.Collectors;

public class BasicJava {

    //count and say

    //pascal triangle
//             1
//             1   1
//             1   2   1
//             1   3   3   1
//             1   4   6   4   1
    static void pascalTriangle(int level) {
        if (level == 1)
            System.out.println(1);
        else if (level == 2) {
            System.out.println(1);
            System.out.println(1);
        } else {
            int[] preArray = new int[level];
            int[] newArray = new int[level];

            preArray[0] = 1;
            preArray[1] = 1;

            for (int i = 3; i <= level; i++) {
                newArray[0] = 1;
                newArray[level - 1] = 1;

                for (int j = 1; j < preArray.length - 1; j++) {
                    newArray[j] = preArray[j] + preArray[j - 1];

                }

                for (int k = 0; k < newArray.length; k++) {
                    preArray[k] = newArray[k];
                }

            }
            for (int i = 0; i < newArray.length; i++) {
                System.out.println(newArray[i]);
            }
        }

    }

    static void swap(int[] preArray, int[] newArray) {
        int[] temp = preArray;
        preArray = newArray;
        newArray = temp;
    }


    // this solution has 2N comparisions
//    static int search(int[] arr, int a, int numberOfElementsInArray){
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] == a) return 1;
//
//        }
//        return -1;
//    }

    //solution with N+1 comparisons
    static boolean search(Integer[] arr, int a, int numberOfElementsInArray) {
        System.out.println(arr.length);
        arr[numberOfElementsInArray] = a;
        int i = 0;
        while (arr[i] != a) i++;
        return i != numberOfElementsInArray; // if this is true means the elemnt was not there, and we inserted it
    }

    // 0,0 1,1 2,2 3,3
    // 0,1 1,2 2,3
    // 0,2 1,3
    // 0,3

    static void patternA(int N) {
        for (int diff = 0; diff < N; diff++) {
            for (int i = 0; i + diff < N; i++) {
                int j = i + diff;
                System.out.println("(" + i + " " + j + ")");
            }
            System.out.println();
        }
    }

    static void patternB(int N) {
        for (int diff = 0; diff < N; diff++) {
            int i = 0;
            int j = i + diff;
            while (j < N) {

                System.out.println("(" + i + " " + j + ")");
                i++;
                j++;
            }
            System.out.println();
        }
    }

    //        (0 0) (0 1) (0 2) (0 3) (0 4)
//
//        (1 0) (1 1) (1 2) (1 3) (1 4)
//
//        (2 0) (2 1) (2 2) (2 3) (2 4)
//
//        (3 0) (3 1) (3 2) (3 3) (3 4)
//
//        (4 0) (4 1) (4 2) (4 3) (4 4)
    static void patternC(int N) {
        for (int level = 0; level < N; level++) {
            for (int j = 0; j < N; j++) {

                System.out.println("(" + level + " " + j + ")");
            }
            System.out.println("\n");
        }
    }

//            (0 0)
//            (1 0) (1 1)
//
//            (2 0) (2 1) (2 2)
//
//            (3 0) (3 1) (3 2) (3 3)
//
//            (4 0) (4 1) (4 2) (4 3) (4 4)

    static void patternD(int N) {
        for (int level = 0; level < N; level++) {
            for (int j = 0; j <= level; j++) {

                System.out.println("(" + level + " " + j + ")");
            }
            System.out.println();
        }
    }

    //        (0 0) (0 1) (0 2) (0 3) (0 4)
//
//        (1 1) (1 2) (1 3) (1 4)
//
//        (2 2) (2 3) (2 4) (3 3) (3 4)
//
//        (4 4)
    static void patternE(int N) {
        for (int level = 0; level < N; level++) {
            for (int j = level; j < N; j++) {

                System.out.println("(" + level + " " + j + ")");
            }
            System.out.println();
        }
    }


    //Find max of 3 elements
    static int maxNumbers(int[] arr) {
        int pointer = 0;
        int max = arr[pointer];
        for (int i = 1; i < arr.length; ) {
            if (arr[i] > arr[pointer]) {
                max = arr[i];
                pointer = i;
                i = pointer + 1;
            } else i++;
        }
        return max;
    }

    //Find min of 3 elements
    static int minNumbers(int[] arr) {
        int pointer = 0;
        int min = arr[pointer];
        for (int i = 1; i < arr.length; ) {
            if (arr[i] < arr[pointer]) {
                min = arr[i];
                pointer = i;
                i = pointer + 1;
            } else i++;
        }
        return min;
    }

    static int findMiddleOfThree(int a, int b, int c) {
        if ((b > c && b < a) || (b < c && b > a))
            return b;
        else if ((a > c && a < b) || (a < c && a > b))
            return a;
        else return c;
    }

    static void printSeries(int N) {
        for (int level = 1; level <= N; level++) {
            for (int j = 1; j <= level; j++) {
                System.out.println(j);
            }
            System.out.println();
        }
    }

    static void printSeriesReverse(int N) {
        for (int level = N; level >= 1; level--) {
            for (int j = 1; j <= level; j++) {
                System.out.println(j);
            }
            System.out.println();
        }
    }

    static Integer[] oddElements(int[] arr) {
//        Integer[] a= new Integer[arr.length];
//        int k=0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]%2 !=0){
//                a[k]=arr[i];
//                k++;
//            }
//        }
//        for(int i=0;i<a.length;i++)
//        System.out.println(a[i]);
//        return a;

        //or using ArrayList so i dont return 0/null at end
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                al.add(arr[i]);
            }
        }
        System.out.println(al);
//        return al.stream().mapToInt(Integer::intValue).toArray();
        return al.toArray(new Integer[0]);
    }

    static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int firstEven(int[] arr) {
        int even = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even = arr[i];
                break;
            }
        }
        return even;
    }


    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        int lastPos = str.length() - 1;
        if (str.charAt(0) != str.charAt(lastPos)) {
            return false;
        }
        String newStr = str.substring(1, lastPos);
        return isPalindrome(newStr);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};

    }

    public int[] twoSumSorted(int[] nums, int target) {
        int[] res = new int[2];
        A:
        for (int i = 0; i < nums.length; i++) {
            B:
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + "  " + j);
                    res[0] = i+1;
                    res[1] = j+1;
                    break A;
                }
            }
        }
        return res;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t= m+n-1;int j=nums2.length-1;
        for(int i=m-1;i>=0;){
            for(;j>=0 && i>=0;){
                if(nums2[j]>=nums1[i]){
                    nums1[t]=nums2[j];
                    j--;
                    t--;
                }
                else if(nums2[j]<nums1[i]){
                    nums1[t]=nums1[i];
                    i--;
                    t--;
                }
            }
            while (i>=0){
                nums1[t]=nums1[i];
                i--;
                t--;
            }

        }
        while (j>=0){
            nums1[t]=nums2[j];
            j--;
            t--;
        }

        if(m==0){
            nums1[0]=nums2[0];
        }

        for(int k=nums1.length-1;k>=0;k--){
            System.out.println(nums1[k]);
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;

        List<Integer> first_row = new ArrayList<>();
        if (numRows == 1) {
            first_row.add(1);
            triangle.add(first_row);
            return triangle;
        }
        first_row.add(1);
        triangle.add(first_row);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prev_row.get(j - 1) + prev_row.get(j));
            }
            row.add(1);

            triangle.add(row);
        }
        List<Integer> toPrint = triangle.get(numRows - 1);
        System.out.println(toPrint);
        return triangle;
    }

    public int maxProfit(int[] prices) {//7,1,5,3,6,4

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if (maxProfit < price - minPrice) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {//7,1,5,3,6,4

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ) {
            if (prices[i] < minPrice)
                minPrice = prices[i++];
            else if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
                i++;
            } else
                i++;
        }

        return maxProfit;
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            } else if (hashMap.containsKey(nums[i]))
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);

        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + "=" + value);

            if (entry.getValue() > nums.length / 2)
                return entry.getKey();

        }
        return -1;
    }

    public List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.contains(nums[i])) continue;
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            } else if (hashMap.containsKey(nums[i]))
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);

            if (hashMap.get(nums[i]) > nums.length / 3 && !res.contains(nums[i])) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) { // -1,0,1,2,-1,-4

        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    return target;
                }

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closestSum;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) { // 1,0,-1,0,-2,2 || -2,-1,0,0,1,2

        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
//        List<List<Integer>> setOfInt = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
            for (int j = i + 1; j < nums.length; j++) {

//                if (j > i+1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        s.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
//                        while (k < l && nums[k] == nums[k - 1]) {
//                            k++;
//                        }
//
//                        while (k < l && nums[l] == nums[l + 1]) {
//                            l--;
//                        }
                    } else if (target > sum) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }

        }

        output.addAll(s);
        return output;
    }

    public static void rotate(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = i+1; j < colLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("Transposed Matrix:");
        printMatrix(matrix);

        for (int i = 0; i < rowLength; i++) {
            for (int j = colLength-1; j >= colLength/2; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][colLength-(j+1)];
                matrix[i][colLength-(j+1)] = temp;
            }
        }

        System.out.println("Reversed transposed Matrix:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
       List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
       for(int i=lower;i < nums.length;){
           if(nums[i]==Integer.MAX_VALUE)
               break;
           if(nums[i] == lower){
               i++;
               lower++;
           }
           else if(lower<nums[i]){
               if(nums[i]-lower == 1)
               {
                   res.add( sb.append(lower).toString());
                   sb.setLength(0);
                   lower=nums[i]+1;
                   i++;
               }
               else{
                   sb.append(lower + "->");
                   sb.append(nums[i]-1);
                   res.add( sb.toString());
                   sb.setLength(0);
                   lower=nums[i]+1;
                   i++;
               }
           }
           if(i==nums.length && lower<upper){
               sb.append(lower + "->");
               sb.append(upper);
               res.add( sb.toString());
               sb.setLength(0);
           }

//           boolean boo =  calculateBoolean(nums,i,counter);
//           if(boo)
//           {
//               i++;
//
//               if(start!=Integer.MIN_VALUE){
//                   if(start == counter-1){
//                       res.add(sb.substring(0,1).toString());
//                       sb.setLength(0);
//                   }
//                   else {
//                       sb.append(counter-1+" ");
//                       res.add(sb.toString());
//                       sb.setLength(0);
//                   }
//               }
//               counter++;
//
//           }
//           else if(!boo) {
//               if (i !=0 && nums[i - 1] != counter-1) {
//                   counter++;
//               }
//               else if(i==0 && start ==Integer.MIN_VALUE){
//                   start = counter;
//                   sb.append(counter +"->");
//                   counter++;
//               }
//               else if(i==0 && start !=Integer.MIN_VALUE){
//                   counter++;
//               }
//               else if (nums[i - 1] == counter-1) {
//                   start = counter;
//                   sb.append(counter + " ->");
//                   counter++;
//               }
//           }
       }
        return res;
    }
    private static boolean calculateBoolean(int[] nums, int i, int counter){
        if(nums[i]==counter){
            return true;
        }
        else {
        }
        return false;
    }

    public static int threeSumSmaller(int nums[], int target){
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            sum +=twoSumSmaller(nums, target-nums[i],i+1);
        }
        return sum;
    }

    public static int twoSumSmaller(int nums[], int target, int start){
        int sum=0;
        int left = start;
        int right = nums.length-1;
        while(left<right){
            if(nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            }else {
                    right--;
                }

            }
            return sum;
        }

//    public static int lengthOfLongestSubstring(String s) {
//        if(s.length()<=1) return s.length();
//        int longest = 0;
//        for(int i=0;i<s.length();i++){
//            int count =0;
//            ArrayList<Character> arrayList = new ArrayList<>();
//            for(int j=i;j<s.length();j++){
//
//                if(!arrayList.contains(s.charAt(j))) {
//                    arrayList.add(s.charAt(j));
//                    count++;
//                    longest = Math.max(longest,count);
//                }
//                else
//                    break;
//            }
//        }
//        return longest;
//    }

    public static int lengthOfLongestSubstring(String s) {
        String st = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = st.indexOf(ch);
            if (index != -1) {
                st = st.substring(index + 1);
            }
            st=st+ch;
            maxLength = Math.max(maxLength, st.length());
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 5};
        Integer[] arr1 = {1, 3, 0, 4, null, null};
//        System.out.println(search(arr1,10,4));
//        patternA(4);
//        patternE(5);
//        System.out.println(minNumbers(arr));
//        System.out.println(findMiddleOfThree(14,15,10));
//        oddElements(arr);
//        System.out.println(firstEven(arr));
//        pascalTriangle(4);
//        List<List<Integer>> pascal = generate(5);
//        System.out.println(pascal);
//        Scanner input = new Scanner(System.in);
//        System.out.println("Welcome to Palindrome Checker");
//        System.out.print("Enter the string to be checked: ");
//        String str = input.next();
//        System.out.println("Your string is "
//                + ((isPalindrome(str) ? "Palindrome"
//                : "Not Palindrome")));
//        System.out.println(maxProfit2(new int[]{1,2,3,4,5}));
//        System.out.println((threeSum(new int[]{-1,0,1,2,-1,-4})));
//        System.out.println((fourSum(new int[]{-2,-1,-1,1,1,2,2},0)));
//        int rows = 4;
//        int columns = 4;
//        int[][] matrix = new int[rows][columns];
//
//        // Initialize the matrix with values
//        // For example, you can use nested loops to assign values
//        int value = 1;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                matrix[i][j] = value;
//                value++;
//            }
//        }
//
//        // Print the matrix
//        System.out.println("2D Matrix:");
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        rotate(matrix);
//        System.out.println(findMissingRanges(new int[]{ 3, 5,8,75},0,99));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }


}



