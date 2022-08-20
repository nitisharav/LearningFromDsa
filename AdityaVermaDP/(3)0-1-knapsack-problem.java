//Problem 3
//Link=https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
//dp using Top down


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
     static int max(int a, int b)
    {
      return (a > b) ? a : b;
    }
    static int knapSackRes(int W, int wt[], int val[], int n , int t[][])
    
    { 
       //Initialisation
       for(int i=0;i<n+1;i++){
           for(int j=0;j<W+1;j++){
              if (i==0|| j==0) {
                  t[i][j]=0;
              } 
           }
       }
   
         // your code here
         for(int i=1;i<n+1;i++){
           for(int j=1;j<W+1;j++){
                if (wt[i-1]<=j)
          t[i][j]=max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j] );
         
         else if (wt[i-1]>j)  t[i][j]=t[i-1][j];
               
           }
         }
       
      
       
         return  t[n][W];
    } 
    
    static int knapSack(int W, int wt[], int val[], int n){
         int[][] t = new int[n+1][W+1]; 
        // for(int[] arr1 : t) 
 // Arrays.fill(arr1, -1);
      return   knapSackRes(W,wt,val,n, t);
        
    }
    
}
//This solution passed 1210/1210 test case
//Learning
//1. Top down approach remove recursive approach from memorization technique
//2. It does not cause stack over flow error like in recursion
//3. step 1 , first make matrix of size (n+1)(W+1), where each cell is max profit at particular capacity(W) and items(n);
//step 2, Like base condn in Recursion, we provide initialization in top down matrix
//step 3, In the matrix n resembles i, W resembles j, so for n==0 or W==0, t[i][j]=0, first row and first column of matrix become zero. This step is initialization
//step 4,Now convert recursion to top down approach, since matrix is already filled for i==0 or j==0, we run for loop from i==1 or j==1
//step 5 knapSackRes(W-wt[n-1],wt,val,n-1,t) will convert into t[i-1][j-wt[i-1]],
//step 6 Using above method , we will fill each matrix cell with answers for that particular n and W  (i and j), 
//step 7, Return t[n][W] as answer(bottom right corner cell of matrix) , as it will check for W capacity and n items, which was required for answer. 

//This is Top Down Approach
