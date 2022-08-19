//problem 1
//Link= https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
//Recursion technique
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
     static int max(int a, int b)
    {
      return (a > b) ? a : b;
    }
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         if (n==0|| W==0) return 0;
         
         if (wt[n-1]<=W)
         return max(val[n-1]+knapSack(W-wt[n-1],wt,val,n-1), knapSack(W,wt,val,n-1) );
         
         else if(wt[n-1]>W) return knapSack(W,wt,val,n-1);
         
         return 0;
    } 
}


//This solution giving TLE for 1163/1210 test case
//Learning
//step1 write base case by considering smallest valid input, and return value at min val
//step 2 write recursion using choice diagram
//step 3 start from end of array for writing recursion
