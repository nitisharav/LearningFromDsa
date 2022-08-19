//Problem 2
//Link=https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

//dp using memorization




class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
     static int max(int a, int b)
    {
      return (a > b) ? a : b;
    }
    static int knapSackRes(int W, int wt[], int val[], int n , int t[][])
    
    { 
       
   
         // your code here
         if (n==0|| W==0) return 0;
         if (t[n][W]!= -1) return t[n][W];
         
         if (wt[n-1]<=W)
         return t[n][W]=max(val[n-1]+knapSackRes(W-wt[n-1],wt,val,n-1,t), knapSackRes(W,wt,val,n-1,t) );
         
         else if(wt[n-1]>W) return t[n][W]=knapSackRes(W,wt,val,n-1,t);
         
         return 0;
    } 
    
    static int knapSack(int W, int wt[], int val[], int n){
         int[][] t = new int[n+1][W+1]; 
         for(int[] arr1 : t) 
  Arrays.fill(arr1, -1);
      return   knapSackRes(W,wt,val,n, t);
        
    }
   
}
//Learning
//In java dp using memorization, 
//Step 1 - we define matrix for changing variables in dp(knapsack) method
//step 2 size of matrix= changing variables+1, so it can include all data of changing variable
//step 3 fill matrix with with -1
//step 4 return recursion method and include matrix as argument in recursion method
//step 5, before starting recrsions, check matrix value for changing variable, if not = -1, return the value
//step 6 else run recursion and put the recursive value in matrix(this step will store the value of  recursion for  particular changing variable, so we dont need
// to do recursion again )
//This is memorization technique
