//problem 7
//Link= https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
//TopDown Approach

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for (int x: arr){
            sum=sum+x;
        }
        
        if (sum%2!=0){
            return 0;
        }
        
        
        return  isSubsetSum(N, arr, sum/2);
    }
    static int isSubsetSum(int N, int arr[], int sum){
     //matrix amking   
         boolean[][] t = new boolean[N+1][sum+1];
        
         // initialisation
        for (int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                if(i==0) t[i][j]=false;
                if(j==0) t[i][j]=true;
            }
        }
        int res=isSubsetSumRes(N,arr,sum, t);
        return  res;
    }
//This solution passed 34/34 test case
//Learning

    static int isSubsetSumRes(int N, int arr[], int sum, boolean t[][]){
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
        
        int result= t[N][sum]== true ? 1 : 0;
        return result;
        
    }

  //This solution passed 140/140 test case
//Learning
  //1. Used (6)subset-sum-problem to solve this problem
  //2. This Question can be converted to (6)subset-sum-problem 
  //Step 1, partion of array as P1 and P2, sum of P1 =S1, sum of P2 =S2
  //Step 2, Partition should be equal in sum , so S1==S2, We take S1=S2 as S which is equal sum of array/2, i.e. (S1+S2)/2=S
  //Step 3, Now if we find one partition(Subset) as equal to half of array sum=S, This question get converted to (6)subset-sum-problem
  //Step 5, it becomes like return true if found any subset whose sum = sum of array elements/2
