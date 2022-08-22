//problem 8
//Link= https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1
//TopDown Approach

class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    //matrix making   
         int[][] t = new int[n+1][sum+1];
        
         // initialisation
        for (int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                if(i==0) t[i][j]=0;
                if(j==0) t[i][j]=1;
            }
        }
        return  isSubsetSumRes(n,arr,sum, t);
	 
	} 
	


    static int isSubsetSumRes(int N, int arr[], int sum, int t[][]){
        //converting recursion into iteration
             for (int i=1;i<t.length;i++){
            for(int j=1;j<t[i].length;j++){
                if(arr[i-1]<=j)
                {
                    t[i][j]= t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else 
                t[i][j]= t[i-1][j];
                
            }
             }
        
        
        return t[N][sum];
        
    }
}

//Learnings
//1. This solution is valid if elements are positive and non zero only.
//2. Converted (6)subset-sum-problem for solution
//step 1,convert boolean matrix into int matrix
//step 2, During intialisation, we filled 1 in place True and 0 in place of False
//Step 3. t[i][j]= t[i-1][j-arr[i-1]] + t[i-1][j]; changed || into +, that is t[i][j]= count of subset, if subset is perfect sum 1 will be added else 0 will be added
//step 4 t[N][sum] corner right bottom of matrix is answer
