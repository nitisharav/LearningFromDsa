//Problem 16
//Link= https://leetcode.com/problems/longest-common-subsequence/
//dp using memorization

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m=text2.length();
        char ch1[]=text1.toCharArray();
        char ch2[]= text2.toCharArray();
        
        int t[][]= new int [n+1][m+1];
        for (int i=0;i<t.length;i++){
            for (int j=0;j<t[i].length;j++){
               t[i][j]=-1;
            }
        }
        return lcs(ch1,ch2, n,m, t);
        
    }
    //using recursion technique
   public int lcs(char ch1[],char ch2[], int n, int m, int t[][]) {
       //base condn
       if(n==0 || m==0) return 0;
       //checking before recursion
        if(t[n][m]!= -1) return t[n][m];
       //Rescursion using choice diagram
       if(ch1[n-1]==ch2[m-1]){
           return t[n][m]= lcs(ch1,ch2,n-1,m-1,t)+1;
       }
       else return t[n][m]= Math.max(
       lcs(ch1,ch2,n-1,m,t),lcs(ch1,ch2,n,m-1,t)
       );
       
   
   }
}
//This solution passed all test cases
//Learning
// similar technique used as
//(2)0-1-knapsack-problem
