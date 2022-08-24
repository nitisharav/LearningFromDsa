//problem 15
//Link= https://leetcode.com/problems/longest-common-subsequence/submissions/
//Recursion technique

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m=text2.length();
        char ch1[]=text1.toCharArray();
        char ch2[]= text2.toCharArray();
        
        return lcs(ch1,ch2, n,m);
        
    }
    //using recursion technique
   public int lcs(char ch1[],char ch2[], int n, int m) {
       //base condn
       if(n==0 || m==0) return 0;
       //Rescursion using choice diagram
       if(ch1[n-1]==ch2[m-1]){
           return lcs(ch1,ch2,n-1,m-1)+1;
       }
       else return Math.max(
       lcs(ch1,ch2,n-1,m),lcs(ch1,ch2,n,m-1)
       );
       
   
   }
}

//This solution giving TLE on submit
//Learning
//1. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
//2. we added 1 if last character equal because this means 1 required subsequece found.
//step1 write base case by considering smallest valid input, and return value at min val
//step 2 write recursion using choice diagram
//step 3 start from end of array for writing recursion

