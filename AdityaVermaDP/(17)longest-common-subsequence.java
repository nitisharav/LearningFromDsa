//Problem 17
//Link= https://leetcode.com/problems/longest-common-subsequence/
//dp using memorization

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m=text2.length();
        char ch1[]=text1.toCharArray();
        char ch2[]= text2.toCharArray();
        //matrix initialisation
        int t[][]= new int [n+1][m+1];
        for (int i=0;i<t.length;i++){
            for (int j=0;j<t[i].length;j++){
              if(i==0 || j==0) t[i][j]=0;
            }
        }
        return lcs(ch1,ch2, n,m, t);
        
    }
    //using topdown technique
   public int lcs(char ch1[],char ch2[], int n, int m, int t[][]) {
   
  for (int i=1;i<t.length;i++){
            for (int j=1;j<t[i].length;j++){
                 //Rescursion to Iteration using choice diagram
       if(ch1[i-1]==ch2[j-1]){
            t[i][j]= 1+t[i-1][j-1];
       }
       else t[i][j]= Math.max(
       t[i-1][j],t[i][j-1]
       );
                
            }
  }
      
    return t[n][m];   
   
   }
}

//This solution passed all test cases
//Learning
//Used similar technique as in (3)0-1-knapsack-problem
