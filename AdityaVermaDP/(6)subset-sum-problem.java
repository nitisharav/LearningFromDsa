//Problem 4
//Link=https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
//dp using top down

class Solution{
   
    static Boolean isSubsetSum(int N, int arr[], int sum){
     //matrix making   
         boolean[][] t = new boolean[N+1][sum+1];
        
         // initialisation
        for (int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                if(i==0) t[i][j]=false;
                if(j==0) t[i][j]=true;
            }
        }
        return  isSubsetSumRes(N,arr,sum, t);
    }


    static Boolean isSubsetSumRes(int N, int arr[], int sum, boolean t[][]){
        //converting recursion into iteration
             for (int i=1;i<t.length;i++){
            for(int j=1;j<t[i].length;j++){
                if(arr[i-1]<=j)
                {
                    t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else 
                t[i][j]= t[i-1][j];
                
            }
             }
        
        
        return t[N][sum];
        
    }
    
    
}
//This solution passed 34/34 test case
//Learning
//1. Top down approach remove recursive approach from memorization technique
//step 1, make matrix of size N+1,Sum+1
//step 2, initailise matrix for n==0(i==0) as false in first row of matrix, false because,for sum>0 and with no item, not possible any subset == sum
//step 3,  initailise matrix for sum==0(j==0) as true in first column of matrix, this will override t[0][0]= true, This means for sum ==0,  empty subset is there
//step 5, comparatively knapsnack top down,max convert to ||
//step 6, we ignore val[i-1] as in subset  we compared arr[] with wt[] of knapsnack.
//step 7, return t[N][sum], corner right bottom cell as answer
