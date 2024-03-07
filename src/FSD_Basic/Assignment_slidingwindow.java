package FSD_Basic;

import java.util.ArrayList;
import java.util.LinkedList;

public class Assignment_slidingwindow {

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
        boolean[] count = new boolean[256];
        int first = 0, second = 0, len = 0;

        while (second < s.length()) {
            // Repeating character
            while (count[s.charAt(second)]) {
                System.out.println(s.charAt(second)+"   "+count[s.charAt(second)]+"   "+count[33]);
                count[s.charAt(first)] = false;//ascii value count array me change hogi
                first++;
            }
            count[s.charAt(second)] = true;
            len = Math.max(len, second - first + 1);
            second++;
        }
        return len;
    }

    public int findSubString( String str) {
        // Your code goes here
        int[] count = new int[256];
        int first=0,second=0,len=str.length(),diff=0;

        //Calculate all the unique char
        while(first<str.length()){
            if(count[str.charAt(first)]==0){
                diff++;
            }
            count[str.charAt(first)]++;
            first++;
        }
        //make all value of count array 0 again
        first=0;
        for(int i=0; i<256;i++){
            count[i]=0;
        }
        while(second<str.length()){
            //while diff exist
            while(diff>0 && second<str.length()){
                if(count[str.charAt(second)]==0){
                    diff--;
                }
                count[str.charAt(second)]++;
                second++;
            }
            len = Math.min(len,second-first);
            //while diff does not become 1
            while(diff!=1){
                len = Math.min(len,second-first);//new length of new window
                count[str.charAt(first)]--;

                if(count[str.charAt(first)]==0){
                    diff++;
                }
                first++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("!ab!cdecb"));

    }
}
