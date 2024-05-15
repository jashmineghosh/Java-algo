package queue;

import java.util.*;

 class General_queue {
     public static Queue<Integer> rev(Queue<Integer> q) {

         Stack<Integer> stack = new Stack<>();

         while (q.size() > 0) {
             stack.push(q.poll());
         }
         while (stack.size() > 0) {
             q.add(stack.pop());
         }
         return q;
     }

     public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
         // add code here.
         Stack<Integer> stack = new Stack();
         while (k >= 0) {
             stack.push(q.poll());
             k--;
         }
         int s = q.size();
         while (!stack.isEmpty()) {
             q.offer(stack.pop());
         }
         while (s != 0) {
             int i = q.poll();
             q.add(i);
             s--;
         }
         return q;
     }

     public static int timeRequiredToBuy(int[] tickets, int k) {

//         Queue<Integer> queue = new LinkedList<>();
//         int size = tickets.length;
//         ;
//         for (int i = 0; i < size; i++) {
//             queue.add(i);
//         }
//         int time = 0;
//         while (tickets[k] != 0) {
//            tickets[queue.peek()]--;
//            if(tickets[queue.peek()]!=0)
//                queue.add(queue.peek());
//            queue.poll();
//            time++;
//         }
//         return time;

         int time=0;

         int n=tickets.length;

         for(int i=0;i<=k;i++)
         {
             time+=Math.min(tickets[i],tickets[k]);
         }


         for(int i=k+1;i<n;i++)
         {
             time+=Math.min(tickets[i],tickets[k]-1);

         }

         return time;
     }

//     public static long[] printFirstNegativeInteger(long A[], int N, int K)
//     {
//
//         ArrayList<Long> arrayList = new ArrayList<>();
//         Queue<Long> queue= new LinkedList();
//         for(int i=0;i<K-1;i++){
//             queue.add(A[i]);
//         }
//         for(int i=K-1;i<N;i++){
//
//             queue.add(A[i]);
//             Queue<Long> queueCopy= new LinkedList<>(queue);
//             arrayList.add(getNegativeNumber(queueCopy));
//             System.out.println("==="+arrayList);
//             queue.poll();
//         }
//         long[] array = new long[arrayList.size()];
//         for (int i = 0; i < arrayList.size(); i++) {
//             array[i] = arrayList.get(i); // Auto-unboxing Long to long
//         }
//         return array;
//     }

     public static long[] printFirstNegativeInteger(long A[], int N, int K){
         ArrayList<Long> arrayList = new ArrayList<>();
         Queue<Integer> queue= new LinkedList();
         for(int i=0;i<K-1;i++){
             if(A[i]<0)
             queue.add(i);
         }
         for(int i=K-1;i<N;i++) {
             if(A[i]<0)
                 queue.add(i);
             if(!queue.isEmpty() && queue.peek()<=i-K)
                 queue.poll();
             if(!queue.isEmpty()) {
                 arrayList.add(A[queue.peek()]);
                 System.out.println("--" + arrayList);
             }
             else arrayList.add(0L);
         }
         long[] array = new long[arrayList.size()];
         for (int i = 0; i < arrayList.size(); i++) {
             array[i] = arrayList.get(i);
             System.out.println(array[i]);// Auto-unboxing Long to long
         }
         return array;
     }
     public static long getNegativeNumber(Queue<Long> queue){
         while(!queue.isEmpty()){
             if(queue.peek()<0) {
                 return queue.peek();
             }
             queue.poll();
         }
         return 0;
     }
//     https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
     public static String solve(String A) {

         StringBuilder stringBuilder= new StringBuilder();
         ArrayList<Integer> repeated = new ArrayList<>(Collections.nCopies(26, 0));
         Queue<Character> queue = new LinkedList<>();
         for(int i=0;i<A.length();i++){
             if(repeated.get(A.charAt(i)-'a')>=1){
                 int index = A.charAt(i)-'a'; // Get the ASCII value of the character
                 int value = repeated.get(index);   // Get the value at the index
                 repeated.set(index, value + 1);
                 while(!queue.isEmpty() && repeated.get(queue.peek()-'a')>1)
                 {
                     queue.poll();
                 }
                 if(queue.isEmpty())
                     stringBuilder.append("#");
                 else
                     stringBuilder.append(queue.peek());
             }
             else {
                 int index = A.charAt(i)-'a'; // Get the ASCII value of the character
                 int value = repeated.get(index);   // Get the value at the index
                 repeated.set(index, value + 1);
                 queue.add(A.charAt(i));
                 while(repeated.get(queue.peek()-'a')>1)
                 {
                     queue.poll();
                 }
                     stringBuilder.append(queue.peek());
             }
         }
         return stringBuilder.toString();

     }

     public static void main(String[] args) {
         Queue queue = new LinkedList<>();
         queue.add(10);
         queue.add(20);
         queue.add(30);
//         System.out.println("   " + queue.peek());
//         System.out.println(timeRequiredToBuy(new int[]{ 2,3,2,1},2));
//         printFirstNegativeInteger(new long[]{-8, 2, 3, -6, 10},5,2);
         System.out.println(solve("abbac"));
     }
 }

