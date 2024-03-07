package FSD_Basic;

import java.util.*;

import static java.lang.Math.max;

public class Assignment_BinarySearch {
    public static int findDays(int[]arr, int cap) {
        int days = 1; //First day.
        int sum = 0;
        int n = arr.length; //size of array.
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > cap) {
                days += 1; //move to next day
                sum = arr[i]; //load the weight and start summing weight again from this point
            } else {
                //load the weight on the same day.
                sum += arr[i];
            }
        }
        return days;
    }
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < N; i++) {
            high += arr[i];
            low = max(low, arr[i]);
        }

        while (low <= high) {
            int mid = low + (high-low) / 2;
            int numberOfDays = findDays(arr, mid);
            if (numberOfDays <= D) {
                //eliminate right half
                high = mid - 1;
            } else {
                //eliminate left half
                low = mid + 1;
            }
        }
        return low;
    }


    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for(int ele : houses){
            int lo = 0, hi = heaters.length - 1;
            int justOnLeft = -1, justOnRight = -1;//imagine houses and heater on number line, left will be just smaller value
            while(lo <= hi){
                int mid = (lo + hi) / 2;
                if(heaters[mid] == ele){
                    justOnLeft = heaters[mid];
                    justOnRight = heaters[mid];
                    break;

                }
                else if(heaters[mid] < ele){
                    justOnLeft = heaters[mid];
                    lo = mid + 1;
                }
                else{
                    justOnRight = heaters[mid];
                    hi = mid - 1;
                }
            }
            justOnLeft = justOnLeft == -1 ? Integer.MAX_VALUE : ele - justOnLeft;
            justOnRight = justOnRight == -1 ? Integer.MAX_VALUE : justOnRight - ele;
            ans = max(ans, Math.min(justOnLeft, justOnRight));
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low=1;int ans=0;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            high= max(high,piles[i]);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(blackbox(mid,piles,h)){
                high=mid;
            }
            else
                low=mid+1;
        }
        return low;
    }
    public boolean blackbox(int maxpiles,int[] piles,int h){
        int hours=0;
        for(int i:piles){
            int time=i/maxpiles;
            hours+=time;
            if(i%maxpiles!=0) hours++;
        }
        if(hours<=h)
            return true;
        return false;
    }

    static long minTime(int[] arr,int n,int k){
        long end=0;long ans=0;
        long start=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            // start=Math.max(start,arr[i]);
            if(start<arr[i])
                start=arr[i];
            end +=arr[i];
        }
        while(start<=end) {
            long mid = start + (end - start) / 2;
            long numOfPainter = calculateMinTime(arr, mid, k);
            if (numOfPainter >0) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    private static long calculateMinTime(int[] arr, long mid, long k){
        long sum =0;
        for(int i=0;i<arr.length && k>0;i++){
            sum +=arr[i];
            if(sum >mid){
                k--;
                sum = arr[i];
            }
        }
        return k;
    }

    public static int findMax(int[] piles ){
        int n = piles.length;
        int max = piles[0];

        for(int i =0 ; i < n ;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        return max;
    }

    public static int findTotalHours(int[] piles , int hours){
        int n = piles.length;
        int totalHrs = 0;
        for(int i =0 ;i <  n; i++){
            totalHrs += Math.ceil((double) piles[i] /(double) hours);       // type casting
        }

        return totalHrs;
    }
    public int minEatingSpeed1(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        while(low <= high){
            int mid = (low + high)/2;
            int totalHours = findTotalHours(piles , mid);

            if(totalHours <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    public static int findPages(int[]A,int N,int M)
    {
        if(M>N){
            return -1;
        }
        int end=0, start=Integer.MIN_VALUE,ans=0;
        for(int i=0;i<N;i++){
            start=max(A[i],start);
            end+=A[i];
        }
        int page=0,count=0, mid;
        while(start<=end){
            mid = start +(end-start)/2;
//            page=0;count=1;
//            for(int i=0;i<N;i++){
//                page=page+A[i];
//                if(page>mid){
//                    count++;
//                    page=A[i];
//                }
//            }
//            if(count<=M){
//                ans=mid;
//                end=mid-1;
//            }

//            else{
//                start=mid+1;
//            }
            long numOfStudents = calculateMinTime(A, mid, M);
            if (numOfStudents >0) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
    public int NthRoot(int n, int m)
    {
        // code here
        int start=1;
        int end=m;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            long num=(long)Math.pow(mid,n);
            if(num==m)
                return mid;
            else if(num<m)
            {
                start=mid+1;
            }
            else
                end=mid-1;
        }
        return -1;
    }

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);// start is min distance we can start placing cows, hence start=1
        int ans=0; int start =1, end=stalls[n-1]-stalls[0];

        while(start<=end){
            int mid= start +(end-start)/2;int count =1; int pos=stalls[0];
           for(int i=1;i<n;i++){
               if((pos+mid)<=stalls[i]){
                   count++;
                   pos = stalls[i];
               }
           }
           if(count>=k){
               ans=mid;
                start = mid+1;
           }
           else end=mid-1;
        }
        return ans;
    }

    public static int noOfGasStationsBetween(int[] arr, double dist) {
        int cnt = 0, n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            double stationsInBetween = (arr[i + 1] - arr[i]) / dist;
            cnt += stationsInBetween;
        }

        return cnt;
    }

    public static double findSmallestMaxDist(int[] arr, int k) {
        int n = arr.length;
        double maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) maxi =
                Math.max(maxi, (double) (arr[i + 1] - arr[i]));

        double low = 0, high = maxi, diff = 1e-6; // 10^-6
        while(high - low > diff) {
            double mid = low + (high - low) / 2;
            if(noOfGasStationsBetween(arr, mid) <= k)
                high=mid;
            else
                low=mid;
        }

        return high;
    }

    static long buzzTime(int N, long M, long L, long H[], long A[]){
        long start=0, end=Math.max(L,M);

        long ans=0;
        while(start<=end){
            long mid= start+(end-start)/2;
            long fast=0;
            for(long i=0;i<N;i++){
                if(H[(int) i]+A[(int) i]*mid>=L){
                    fast += H[(int) i]+A[(int) i]*mid;
                }
            }
            if(fast>=M){

                end=mid-1;
            }
            else start = mid+1;

        }
        return start;
    }

    public static boolean bloom(int []arr, int m, int k, int days){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=days){
                count++;
            }
            if(count==k){
                m--;
                count=0;
            }
            if(arr[i]>days){
                count=0;
            }
        }
        if(m<=0){
            return true;
        }
        return false;
    }
    public static int Days(int[] arr, int m, int k, int last){
        int s=1,l=last;
        int ans=-1;
        while(s<=l){
            int mid=(s+l)/2;
            // System.out.println(mid);
            if(bloom(arr,m,k,mid)){
                ans=mid;
                l=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int max=bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            max=Math.max(max,bloomDay[i]);
        }
        return Days(bloomDay,m,k,max);
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0 , high = n - 1 ;

        while(low <= high){
            int mid = (low + high)/2;

            int missingNumber = arr[mid] - (mid + 1);

            if(missingNumber < k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return high + 1 + k;
    }

    public class Solution{
        Random random = new Random();
        int max = 0;
        int[] sum;
        public Solution ( int[] w){

            sum = new int[w.length];
            sum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                sum[i] = sum[i - 1] + w[i];
            }
            max = sum[sum.length - 1];

        }

        public int pickIndex () {
            int start=0, end= sum.length-1;
            int target = random.nextInt(max) +1;
            while(start<=end){
                int mid = start + (end-start)/2;
                if(target == sum[mid]){
                    return mid;
                }
                if(sum[mid]>target){
                    end= mid-1;
                }
                else { start=mid+1;}

            }
            return start;
        }
    }


    public static void main(String[] args) {
//        System.out.println(leastWeightCapacity(new int[]{9, 8, 10}, 3,3));
//        System.out.println(findRadius(new int[]{3,9,2,4,11},new int[]{1,5,8}));
//    System.out.println(buzzTime(3,400, 120,new long[]{20,50,20}, new long[]{20,70,90}));
//        System.out.println(findKthPositive(new int []{2,3,4,7,11},5));
//        subsets(new int[]{1,5});
//        System.out.println(sortSentence("is2 sentence4 This1 a3"));
//        System.out.println(minDays(new int[]{1,10,3,10,2},3,2));
        System.out.println(findSmallestMaxDist(new int[]{3,6,12,19,33,44,67,72,89,95},2));

    }

}
