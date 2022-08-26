//Problem 18
//Link= https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
//dp using topdown

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        char ch1[]= S1.toCharArray();
        char ch2[]=S2.toCharArray();
      /* Initialization of variable to store max length of substring*/
          int max = Integer.MIN_VALUE;
        //matrix initialisation
        int t[][]= new int [n+1][m+1];
        for (int i=0;i<t.length;i++){
            for (int j=0;j<t[i].length;j++){
                if (i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }
           //matrix iteration using dp
       /* Iterating over array to fill 2D Array, starting from [1][1] because first
           row and column is filled by 0 in Java during initialization */
                for (int i=1;i<t.length;i++){
            for (int j=1;j<t[i].length;j++){
                if(ch1[i-1]==ch2[j-1]){
                    t[i][j]=1+t[i-1][j-1];
                   // System.out.println(t[i][j]);
                }
                else t[i][j]=0;
               /* If any cell in the 2D array is greater than max then update max
                     which denotes we found a substring which is greater than old substring*/
                  max = Math.max(max,t[i][j]);
            }
                    
                }
               
                return max;
    }
}

//This solution passed all test cases
//Learning
//1. We make 0 at discontinuity
//2.   If any cell in the 2D array is greater than max then update max which denotes we found a substring which is greater than old substring
