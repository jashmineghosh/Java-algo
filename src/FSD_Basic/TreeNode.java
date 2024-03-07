package FSD_Basic;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
          this.right = right;
      }
  }

    class Solution {
        public List<Integer> Traversal(TreeNode root, List<Integer> arr){
            if(root!=null){
                int data=root.val;
                arr.add(data);
                Traversal(root.left,arr);
                Traversal(root.right,arr);
            }
            return arr;
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> arr=new ArrayList<>();
            System.out.println(Traversal(root,arr));
            return Traversal(root,arr);
        }

        public static void main(String[] args) {
            Solution solution= new Solution();
            Scanner scanner= new Scanner(System.in);
            int i= scanner.nextInt();
            TreeNode treeNode = new TreeNode(i);
//            solution.Traversal(treeNode,List.of(1,null,2,3));
            solution.preorderTraversal(treeNode);
        }


    }

