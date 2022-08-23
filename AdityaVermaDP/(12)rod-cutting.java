//Problem 12
//Link=https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
//dp using top down

class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int len[]= new int[n];
        for (int i=0;i<len.length;i++){
            len[i]=i+1;
        }
        int t[][]= new int[n+1][n+1];
        //initialisation
        for (int i=0;i<t.length;i++ ){
            for (int j=0;j<t[i].length;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }
        for (int i=1;i<t.length;i++ ){
            for (int j=1;j<t[i].length;j++){
                if(len[i-1]<=j){
                t[i][j]=    Math.max(price[i-1]+t[i][j-len[i-1]],t[i-1][j]);
                }
                else t[i][j]= t[i-1][j];
            }
            
        }
        return t[n][n];
    }
}
//This solution passed 200/200 test case
//Learning
// similar to 0-1 knapsack
//len[]== wt[]
//N= W
//since we can reinclude many times
//t[i][j]=    Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]) becomes t[i][j]=    Math.max(price[i-1]+t[i][j-len[i-1]],t[i-1][j])
//here t[i-1][j-wt[i-1]] becomes t[i][j-len[i-1]], i-1 to i so we should not exclude once we include it once
//return corener bottom right cell t[n][n]
