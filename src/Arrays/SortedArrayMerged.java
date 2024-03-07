package Arrays;

import java.util.Arrays;

import static Arrays.ArrayUtility.displayArray;

public class SortedArrayMerged {


        public static int[] MargeTwoSortedArray(int[] array1, int[] array2) {
            final int[] mergedArray = new int[array1.length + array2.length];
            int j = 0, k = 0;
            for (int i = 0; i < mergedArray.length; i++) {
                if (j != array1.length && (k == array2.length || array1[j] < array2[k])) {
                    mergedArray[i] = array1[j];
                    j++;
                } else {
                    mergedArray[i] = array2[k];
                    k++;
                }
            }
            return mergedArray;
        }

        public static void main(String[] args) {
//            int[] arr = MargeTwoSortedArray(new int[]{1,1,8,9,10}, new int[]{1,2,8,9,11,15,16});
            int[] arr = MargeTwoSortedArray(new int[]{1,1,8,9,10}, new int[]{2});
            Arrays.stream(arr).forEach(System.out::println);
        }
    }

class IsSortedArray {
    public static void main(String[] args) {
        System.out.println("Welcome to Array Sorting Check post\n");
//        int[] numArr = ArrayUtility.inputArray();
//        boolean isInc = isIncreasing(numArr);
//        boolean isDec = isDecreasing(numArr);
//        int[] newAyy = deleteNumber(numArr,5);
//        displayArray(newAyy);
//        if (isInc || isDec) {
//            System.out.println("Your array is sorted");
//        } else {
//            System.out.println("Your array is not sorted");
//        }

        int[] arr1 = {1,1,8,9};
        int[] arr2 = {1,2,8};
        int[] mergedArr = merge(arr1, arr2);
        System.out.println("Your merged array is:");
        ArrayUtility.displayArray(mergedArr);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int newSize = arr1.length + arr2.length;
        int[] newArr = new int[newSize];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length || j < arr2.length) {
            if (j== arr2.length || (i<arr1.length && arr1[i]<arr2[j])) { //if you want the code to go in loop give ||
                newArr[k] = arr1[i];
                i++;
                k++;
            } else {
                newArr[k] = arr2[j];
                k++;
                j++;
            }
        }
        return newArr;
    }
    public static boolean isDecreasing(int[] numArr) {
        int i = 1;
        while (i < numArr.length) {
            if (numArr[i] > numArr[i-1]) {
                return false;
            }
            i++;
        }
        return true;
    }
    public static boolean isIncreasing(int[] numArr) {
        int i = 1;
        while (i < numArr.length) {
            if (numArr[i] < numArr[i-1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int[] deleteNumber(int[] numArr, int numToDelete) {
        int occ = ArrayUtility.noOfOccurrences(numArr, numToDelete);
        if (occ == 0) {
            return numArr;
        }
        int newSize = numArr.length - occ;
        int[] newArr = new int[newSize];

        int i = 0, j = 0;
        while (i < numArr.length) {
            if (numArr[i] != numToDelete) { // try to give break condition first, coding gets easy
                newArr[j] = numArr[i];
                j++;
            }
            i++;
        }

        return newArr;
    }
}

