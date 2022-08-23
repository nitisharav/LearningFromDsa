//Problem 13
//Link=https://practice.geeksforgeeks.org/problems/coin-change2448/1
//dp using top down

class Solution {
    public long count(int S[], int m, int n) {
        // code here.
        //initialisation
        long t[][]= new long[m+1][n+1];
        for (int i=0;i<t.length;i++){
            for (int j=0;j<t[i].length;j++){
                if(i==0) {
                    t[i][j]=0;
                }
                if(j==0) {
                    t[i][j]=1;
                }
            }
        }
        
        //Iteration top down
                for (int i=1;i<t.length;i++){
            for (int j=1;j<t[i].length;j++){
                if(S[i-1]<=j){
                    t[i][j]=t[i][j-S[i-1]]+t[i-1][j];
                }
                else t[i][j]=t[i-1][j];
            }
                    
                }
                return t[m][n];
    }
}
//passed 20/20 tess cases
//Learnings
//1. Problem similar to (8)PerfectSumProblem but in unbounded form
//2. wt[]-- coin[]
//3. W--- value of all coin(N)
//4. t[i][j-S[i-1]], changed i-1 to i , so get converted in unbounded form,multiple occurences can occur
