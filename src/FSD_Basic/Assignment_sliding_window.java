package FSD_Basic;

import java.util.*;

public class Assignment_sliding_window {

    public static int lengthOfLongestSubstring(String s) {
        List<Boolean> list=new ArrayList<Boolean>(Arrays.asList(new Boolean[256]));
        Collections.fill(list, Boolean.FALSE);
//        boolean[] count = new boolean[256];
        int first=0,second=0,len=0;
        while(second <s.length()){
//

            while (list.get(s.charAt(second))) {
                list.set(s.charAt(first), false);
                first++;
            }
            list.set(s.charAt(second), true);
            len = Math.max(len, second - first + 1);
            second++;
        }
        return len;
    }

//    Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
//    For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.
    public static int findSubString( String str) {
        // Your code goes here
        List<Integer> list = new ArrayList<Integer>(Collections.nCopies(256, 0));
        int first=0,second=0,diff=0; int len = str.length();
        while(first <len){
            if(list.get(str.charAt(first))==0)
                diff++;
            int index = str.charAt(first); // Get the ASCII value of the character
            int value = list.get(index);   // Get the value at the index
            list.set(index, value + 1);    // Increment the value and set it back into the list
            first++;
        }
        for(int i=0;i<256;i++){ //re-set
            list.set(i,0);
            first=0;
        }
        while(second <str.length()){

            while (diff!=0 && second <str.length()) {
                if(list.get(str.charAt(second))==0)
                    diff--;

                int index = str.charAt(second); // Get the ASCII value of the character
                int value = list.get(index);   // Get the value at the index
                list.set(index, value + 1);
                second++;
            }
//            len = Math.min(len, second - first );
            while(diff!=1){
                len = Math.min(len, second - first );
                int index = str.charAt(first); // Get the ASCII value of the character
                int value = list.get(index);   // Get the value at the index
                list.set(index, value - 1);
                if(list.get(str.charAt(first))==0)
                    diff++;
                first++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(findSubString("aabcbcdbca"));

    }
}
