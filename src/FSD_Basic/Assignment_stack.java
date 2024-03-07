package FSD_Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Assignment_stack {
        public static int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Stack < Integer > st = new Stack < > ();
            int leftSmall[] = new int[n];
            int rightSmall[] = new int[n];
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }

                if (st.isEmpty()) leftSmall[i] = 0;
                else leftSmall[i] = st.peek() + 1;
                st.push(i);
            }

            // clear the stack to be re-used
            while (!st.isEmpty()) st.pop();

            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }

                if (st.isEmpty()) rightSmall[i] = n - 1;
                else rightSmall[i] = st.peek() - 1;

                st.push(i);
            }

            int maxA = 0;
            for (int i = 0; i < n; i++) {
                maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
            }
            return maxA;
    }

    public static int trap(int[] height) {
//        int[] toRight= new int[height.length];
//        int[] toLeft= new int[height.length];
//        int sum = 0;
//        int max=Integer.MIN_VALUE;
//        int max1=Integer.MIN_VALUE;
//        for(int i=0;i<height.length;i++){
//            max = Math.max(height[i],max);
//            toRight[i] = max;
//        }
//        for(int i=height.length-1;i>=0;i--){
//            max1 = Math.max(height[i],max1);
//            toLeft[i] = max1;
//        }
//        for(int i=0;i<=height.length-1;i++){
//            height[i] = Math.min(toRight[i],toLeft[i])-height[i];
//            sum += height[i];
//        }
//return sum;



        int left=0;
        int right=height.length-1;
        int leftBar= height[left];
        int rightBar= height[right];
        long ans = 0;
        while ((left<=right)){
            if(leftBar<rightBar) // which bar is limiting
            {
                if(height[left]>leftBar)
                    leftBar=height[left];
                else {
                    ans+=leftBar-height[left];
                    left++;
                }
            }
            else {
                if(height[right]>rightBar)
                    rightBar=height[right];
                else {
                    ans+=rightBar-height[right];
                    right--;
                }

            }
        }
return (int)ans;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){

            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if( !stack.isEmpty()  && c == ')' && stack.peek().equals('(') ){
                stack.pop();
            }
            else if(!stack.isEmpty() && c == '}'  && stack.peek().equals('{') ){
                stack.pop();
            }
            else if(!stack.isEmpty()  && c == ']' && stack.peek().equals('[') ){
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();

    }

    public static String decodeString(String s) {
        Stack<Integer> sti = new Stack<>();
        Stack<StringBuilder> sbs = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            } else if (c == '[') {
                sti.push(n);
                n=0;
                sbs.push(sb);
                sb=new StringBuilder();
            } else if (c == ']') {
               int num=sti.pop();
                StringBuilder temp = sb;
                sb = sbs.pop();

               while(num>0){
                 sb.append(temp);
                  num--;
               }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public int calPoints(String[] operations) {
        int n=operations.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(operations[i].equals("+")){
                int a=st.pop();
                int b=st.pop();
                int c=a+b;
                st.push(b);
                st.push(a);
                st.push(c);
            }
            else if(operations[i].equals("D")){
                int a=st.peek();
                int x=a*2;
                st.push(x);
            }
            else if(operations[i].equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        // Process each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                // Remove duplicate character
                st.pop();
            } else {
                // Push unique character
                st.push(s.charAt(i));
            }
        }

        // Build the result string in the correct order
        StringBuilder sb = new StringBuilder("");
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++)
        {

            if(stack.size()>0&&stack.peek()!=s.charAt(i)){
                if(Math.abs(stack.peek()-s.charAt(i)) == 32){
                    stack.pop();
                }
                else stack.push(s.charAt(i));
//                String t1=""+stack.peek();
//                String t2=""+s.charAt(i);
//                if(t1.toLowerCase().equals(t2.toLowerCase()))stack.pop();
//                else stack.push(s.charAt(i));
            }
            else
                stack.push(s.charAt(i));

        }
        String str="";
        while(stack.size()>0){
            str=stack.pop()+str;
        }
        return str;

    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack();
        Stack<Character> tt = new Stack();

//        for(char ch : s.toCharArray()) {
//            if (!ss.isEmpty() && ch == '#') {
//                ss.pop();
//            }else if(ss.isEmpty() && ch == '#') continue;
//            else ss.push(ch);
//
//        }
//        StringBuilder sss = new StringBuilder();
//        while (!ss.isEmpty()) {
//            sss.append(ss.pop());
//        }
//
//        for(char ch : t.toCharArray()) {
//            if (!tt.isEmpty() && ch == '#') {
//                tt.pop();
//            } else if(tt.isEmpty() && ch == '#') continue;
//            else tt.push(ch);
//
//        }
//        StringBuilder ttt = new StringBuilder();
//        while (!tt.isEmpty()) {
//            ttt.append(tt.pop());
//        }
//
//        return sss.toString().equals(ttt.toString());

        for(char ch : s.toCharArray()) {
            if(ch == '#') {
                if(!ss.isEmpty()) {
                    ss.pop();
                }
            } else {
                ss.push(ch);
            }
        }

        for(char ch : t.toCharArray()) {
            if(ch == '#') {
                if(!tt.isEmpty()) {
                    tt.pop();
                }
            } else {
                tt.push(ch);
            }
        }

        StringBuilder sss = new StringBuilder();
        while(!ss.isEmpty()) {
            sss.append(ss.pop());
        }

        StringBuilder ttt = new StringBuilder();
        while(!tt.isEmpty()) {
            ttt.append(tt.pop());
        }

        return sss.toString().equals(ttt.toString());
    }

    class MyStack {
        public ArrayList<Integer> stack;

        public MyStack() {
            // Initialize ArrayList
            this.stack = new ArrayList<>();
        }

        public void push(int x) {
            this.stack.add(x);
        }

        public int pop() {
            return this.stack.remove(this.stack.size() - 1);
        }

        public int top() {
            return this.stack.get(this.stack.size() - 1);
        }

        public boolean empty() {
            return this.stack.isEmpty();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 5};
        Integer[] arr1 = {1, 3, 0, 4, null, null};
        System.out.println(largestRectangleArea(new int[]{1,2,3,5,6,2,3}));
//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(removeDuplicates("abbaca"));
//        System.out.println(backspaceCompare("y#fo##f","y#f#o##f"));
    }
}
