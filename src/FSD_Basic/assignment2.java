package FSD_Basic;

import java.util.*;

public class assignment2 {

    public void moveZeroes(int[] nums) {
        int constant =0;
        for (int i = 0; i < nums.length;i++ ) {
            if (nums[i] != 0) {
                nums[constant++] = nums[i];

            }
        }

        for (int i = constant; i < nums.length; i++) {
            nums[i] =0;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        if(hs.size()==nums.length)
            return false ;
        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hp=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int current = nums[i];

//            if(hp.containsKey(current) && i - hp.get(current) <= k){
//
//                return true;
//            }else {
//                hp.put(current,i);
//
//            }
//
//        }
//        return false;

            if(hp.containsKey(current))
            {
                if(i- hp.get(current)<=k)
                    return true;
                if(i== nums.length-1 && i- hp.get(current)>k)
                    return false;
            }
            hp.put(current,i);
        }
        return false;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(calculateRange(nums[0], nums[0]));
        }
        else if (nums.length == 0) {
            return list;
        }
        else {
            for (int i = 0, counter = nums[i],start = nums[i]; i < nums.length; ) {

                if (nums[i] == counter && i== nums.length-1) {
                    list.add(calculateRange(start,counter));
                    i++;
                }
                else if (nums[i] == counter) {
                    i++;counter++;
                }
                else if(nums[i] > counter){
                    list.add(calculateRange(start,counter-1));
                    counter=nums[i];
                    start=nums[i];
                }
            }

        }
        return list;
    }

    static String calculateRange (int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append("" + start + "");
        }
        else if (start != end) {
            sb.append("" + start + "->" + end + "");
        }
        return sb.toString();
    }

    class NumArray {
    ArrayList<Integer> al = new ArrayList<>();
    public NumArray(int[] nums) {
        for(int i: nums)
            al.add(i);
    }
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left;i<=right;i++){
            sum +=al.get(i);
        }
        return sum;
    }
}

    class NumMatrix {

        int[][] matrix;
        public NumMatrix(int[][] matrix) {

            if(matrix == null){
                throw  new IllegalArgumentException("Input matrix is null");
            }
            for(int i=0;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j] += matrix[i][j-1];
                }
            }
            for(int i=1;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
            this.matrix= matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int total = matrix[row2][col2];
            int extra = (col1!=0?matrix[row2][col1-1]:0)+(row1!=0?matrix[row1-1][col2]:0)-(row1!=0 && col1!=0?matrix[row1-1][col1-1]:0);
            return total -extra;
        }
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0,i=0;
        while(i<nums.length){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
                i++;
            }
            else
                i++;
        }
        return index;

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList list = new ArrayList();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: nums1){
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }
        for(int i: nums2){
            if(hashMap.containsKey(i) && hashMap.get(i) !=0) {
                // System.out.println("before.."+hashMap);
                list.add(i);
                hashMap.put(i, 0);
                // System.out.println("after.."+hashMap);
            }
            else continue;
        }
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++) ret[i]= (int) list.get(i);
        return ret;
    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        ArrayList list = new ArrayList();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: nums1){
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }
        for(int i: nums2){
            if(hashMap.containsKey(i) && hashMap.get(i) !=0) {
                // System.out.println("before.."+hashMap);
                list.add(i);
                hashMap.put(i, hashMap.get(i)-1);
                // System.out.println("after.."+hashMap);
            }
            else continue;
        }
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++) ret[i]= (int) list.get(i);
        return ret;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length];

        for (int i = 0; i < nums3.length ; i++)
        {
            nums3[i] =  findNextMaxNum(nums2 , nums1[i]);
        }
        return nums3;
    }

    public static int findNextMaxNum(int[] arr , int n )
    {
        int temp = -1 ;

        for (int i = 0 ; i < arr.length ; i++)
        {
            if (arr[i] == n) {
                while ((i + 1) < arr.length && temp <= n) {
                    i++;
                    temp = Math.max(n, arr[i]);

                }
                break;
            }
        }

        return (temp == n) ? -1 : temp ;
    }

    public static int[] nextGreaterElements(int[] nums) {


        int n = nums.length;
        int size = (n*2) - 1, k = n - 1;
        Stack<Integer> stck = new Stack();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        while(size >= 0) {
            int idx = size%n;

            while(!stck.isEmpty() && stck.peek() <= nums[idx])
                stck.pop();

            if(size < n) {
                if(!stck.isEmpty() && stck.peek() > nums[idx])
                    ans[k] = stck.peek();
                k--;
            }

            stck.push(nums[idx]);
            size--;
        }

        return ans;
    }

    public static String rankTeams(String[] votes) {
//        int len = votes[0].length();
//        int[][] map = new int[26][len + 1];
//        for(int i = 0; i < 26; i++) map[i][len] = i;
//
//        for(int i = 0; i < votes.length; i++){
//            String s = votes[i];
//            for(int j = 0; j < len; j++){
//                map[s.charAt(j) - 'A'][j]++;
//            }
//        }
//        Arrays.sort(map, (a, b) ->{
//            for(int i = 0; i < len; i++){
//                if(a[i] < b[i]) return 1;
//                if(a[i] > b[i]) return -1;
//            }
//            return 0;
//        });
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < len; i++){
//            sb.append((char)('A' + map[i][len]));
//        }
//        return sb.toString();

        int n= votes[0].length();
        int[][] rt = new int[26][n];
        for(int i = 0; i < votes.length; i++){
            for(int j = 0; j < n; j++){
                char c = votes[i].charAt(j);
                rt[c - 'A'][j]++;
            }
        }
        Character[] temp = new Character[n];
        for(int i=0;i<n;i++){
            temp[i] = votes[0].charAt(i);
        }
        Arrays.sort(temp, (a, b) ->{
            for(int i = 0; i < n; i++)
                if(rt[a-'A'][i] != rt[b-'A'][i])
                    return rt[b-'A'][i] - rt[a-'A'][i];
               return a-b;

        });
        char res[] = new char[n];
        for(int i=0;i<n;i++){
            res[i] = temp[i];
        }
        return new String(res);


            // Edge case(NOT COMPULSARY)
//            if(votes.length == 1){
//                return votes[0];
//            }
//
//
//
//            // Adding each character to the map
//            Map<Character, int[]> map = new HashMap<>();
//            int v_len = votes[0].length();
//            for (String v : votes) {
//                int idx = 0;
//                for (char ch : v.toCharArray()) {
//                    map.putIfAbsent(ch, new int[v_len]);
//                    map.get(ch)[idx++]++;
//                }
//            }
//
//
//            // Custom Comparator Sort
//            List<Character> list = new ArrayList<>(map.keySet());
//            Collections.sort(list, (a, b) -> {
//                for (int i = 0; i < v_len; i++) {
//                    if (map.get(a)[i] != map.get(b)[i]) {
//                        return map.get(b)[i] - map.get(a)[i];
//                    }
//                }
//                return a - b;
//            });
//
//
//            StringBuilder sb = new StringBuilder();
//            for (char ch : list) {
//                sb.append(ch);
//            }
//            return sb.toString();
        }



    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int x: arr){
            count.put(x,count.getOrDefault(x,0)+1);
        }
        int[] frequency = new int[count.size()];
        int i=0;
        for(int f: count.values()){
            frequency[i++] = f;
        }
        Arrays.sort(frequency);
        int ans = 0, removeSum=0;
        int half= arr.length/2;
        i= frequency.length;
        while (removeSum<half){
            ans++;
            removeSum += frequency[i--];
        }

        return ans;
    }

    public static int nextGreaterElement3(int n) {

        char[] arr = Integer.toString(n).toCharArray();
        int i= arr.length-2;
        while(i>=0 && arr[i] >= arr[i+1]){
            i--;
        }
        if(i==-1) return -1;
        int k= arr.length-1;
        while(arr[k] <= arr[i])
            k--;
        swap(arr,i,k);

        Arrays.sort(arr,i+1,arr.length);
        long ans = Long.valueOf(new String(arr));
        return ans>Integer.MAX_VALUE?-1:(int) ans;
    }
    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 5};
        Integer[] arr1 = {1, 3, 0, 4, null, null};
//        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
//
         int[] arr12 = new int[3];
//           arr12= nextGreaterElement(new int[]{1,3,5,2,4},new int[]{6,5,4,3,2,1,7,9});
//           for(int i=0;i<arr12.length;i++){
//            System.out.println(arr12[i]);
//        }
//        nextGreaterElements(new int[]{1,2,1});
//        arr12 = nextGreaterElements(new int[]{1,2,1});
//        for(int i=0;i<arr12.length;i++){
//            System.out.println(arr12[i]);
//        }
//        System.out.println(nextGreaterElement3(21));
//        System.out.println(removeElement(new int[]{3,2,2,3},3));
//        intersection(new int[]{1,2,2,1},new int[]{2,2});
rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"});
    }
}
