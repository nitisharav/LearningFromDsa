//Problem 5
//Link=https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
//dp using memorization


class Solution{
   
    static Boolean isSubsetSum(int N, int arr[], int sum){
        
         boolean[][] t = new boolean[N+1][sum+1];
         for(boolean[] arr1 : t) 
            Arrays.fill(arr1, false);
         return  isSubsetSumRes(N,arr,sum, t);
    }


    static Boolean isSubsetSumRes(int N, int arr[], int sum, boolean t[][]){
        // base condn
          if (sum==0 && N>=0) return true;
        if (N==0 && sum>0 ) return false;
       
        if (t[N][sum]!= false) return t[N][sum];
        //recursion
        if (arr[N-1]<=sum){
            return t[N][sum]=( isSubsetSum(N-1, arr, sum-arr[N-1])) || 
            isSubsetSum(N-1, arr, sum);
        } else if(arr[N-1]>sum) return t[N][sum]= isSubsetSum(N-1, arr, sum);
        
        return false;
        
    }
    
    
}
//This solution showed TLE test case ON submission
//Learning
//Took help from knapsack memorization, solved similarly
