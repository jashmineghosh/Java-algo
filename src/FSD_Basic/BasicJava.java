package FSD_Basic;

import java.util.ArrayList;

public class BasicJava {

    // this solution has 2N comparisions
//    static int search(int[] arr, int a, int numberOfElementsInArray){
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] == a) return 1;
//
//        }
//        return -1;
//    }

    //solution with N+1 comparisons
    static boolean search(Integer[] arr, int a, int numberOfElementsInArray){
        System.out.println(arr.length);
        arr[numberOfElementsInArray] = a;
        int i=0;
        while(arr[i] != a) i++;
        return i != numberOfElementsInArray; // if this is true means the elemnt was not there, and we inserted it
    }

    // 0,0 1,1 2,2 3,3
    // 0,1 1,2 2,3
    // 0,2 1,3
    // 0,3

    static void patternA(int N){
        for(int diff=0;diff <N; diff++){
            for(int i=0; i+diff < N;i++){
                int j = i+diff;
                System.out.println("("+i+" "+j+")");
            }
            System.out.println();
        }
    }

    static void patternB(int N){
        for(int diff=0;diff <N; diff++){
            int i=0;
            int j = i+diff;
            while( j < N){

                System.out.println("("+i+" "+j+")");
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
    static void patternC(int N){
        for(int level=0;level < N; level++){
            for(int j=0;j < N; j++){

                System.out.println("("+level+" "+j+")");
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

    static void patternD(int N){
        for(int level=0;level < N; level++){
            for(int j=0;j <= level; j++){

                System.out.println("("+level+" "+j+")");
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
    static void patternE(int N){
        for(int level=0;level < N; level++){
            for(int j=level;j < N; j++){

                System.out.println("("+level+" "+j+")");
            }
            System.out.println();
        }
    }



    //Find max of 3 elements
    static int maxNumbers(int[] arr){
        int pointer = 0;
        int max = arr[pointer];
        for(int i=1;i< arr.length;){
            if(arr[i]> arr[pointer]){
                max= arr[i];
                pointer = i;
                i= pointer+1;
            }
            else i++;
        }
        return max;
    }

    //Find min of 3 elements
    static int minNumbers(int[] arr){
        int pointer = 0;
        int min = arr[pointer];
        for(int i=1;i< arr.length;){
            if(arr[i]< arr[pointer]){
                min= arr[i];
                pointer = i;
                i= pointer+1;
            }
            else i++;
        }
        return min;
    }

    static int findMiddleOfThree(int a, int b, int c){
        if((b >c && b<a) || (b <c && b>a))
            return b;
        else if((a >c && a<b) || (a <c && a>b))
            return a;
        else return c;
    }
    static void printSeries(int N){
        for(int level=1;level <= N; level++){
            for(int j=1;j <= level; j++){
                System.out.println(j);
            }
            System.out.println();
        }
    }

    static void printSeriesReverse(int N){
        for(int level=N;level >= 1; level--){
            for(int j=1;j <= level; j++){
                System.out.println(j);
            }
            System.out.println();
        }
    }

    static Integer[] oddElements(int[] arr){
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
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2 !=0) {
                al.add(arr[i]);
            }
        }
        System.out.println(al);
//        return al.stream().mapToInt(Integer::intValue).toArray();
        return  al.toArray(new Integer[0]);
    }

    static int sumOfArray(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
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
    public static void main(String[] args) {
        int [] arr = {1,2,6,3,5};
        Integer [] arr1 = {1,3,0,4,null, null};
//        System.out.println(search(arr1,10,4));
//        patternA(4);
//        patternE(5);
//        System.out.println(minNumbers(arr));
//        System.out.println(findMiddleOfThree(14,15,10));
        oddElements(arr);
//        System.out.println(firstEven(arr));
    }
}
