//Problem 4
//Link=https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
//dp using recursion


class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // base condn
        if (sum==0 && N>=0) return true;
        if (N==0 && sum>0 ) return false;
        //recursion
        if (arr[N-1]<=sum){
            return ( isSubsetSum(N-1, arr, sum-arr[N-1])) || 
            isSubsetSum(N-1, arr, sum);
        } else if(arr[N-1]>sum) return isSubsetSum(N-1, arr, sum);
        
        return true;
        
    }
    
    
}
//This solution showed TLE test case ON submission

//Learning
// step 1 Identified knapsack similarity, (i)choice (ii) max Sum(capacity)
//step2 , derived base condn, for minmum value of sum and N
//step 3 , for true false, max converted to ||
// step 4, wrote recursion like knapsack 
// step 5 , at end return true or false, code wont run over their , it will return from base condn
