//Problem 19
//Link= https://www.geeksforgeeks.org/printing-longest-common-subsequence/
// Printing Longest Common Subsequence
// Given two sequences, print the longest subsequence present in both of them.
// Example:
// LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. 
//dp using topdown


class Solution3 {
	 public static void main(String[] args)
	    {
	        String X = "AGGTAB";
	        String Y = "GXTXAYB";
	        int m = X.length();
	        int n = Y.length();
	        
	        System.out.println(longestCommonSubsequence(X, Y));
	    }
    public static String longestCommonSubsequence(String text1, String text2) {
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
   public static String lcs(char ch1[],char ch2[], int n, int m, int t[][]) {
   
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
      int i=n;
      int j=m;
      String res="";
      while(i>0 && j>0) {
    	  if(ch1[i-1]==ch2[j-1]) {
    		  res=ch1[i-1]+res;
    		  i--;
    		  j--;
    	  }
    	  else {
    		  if(t[i][j-1]>t[i-1][j]) {
    			  j--;
    		  }
    		  else i--;
    	  }
      }
    return res;   
   
   }
}

//Learning
// After getting LCS , move from corner right  bottom , while checking if(ch1[i-1]==ch2[j-1]) move diagonally back and add that char to result String
//else check  whichever is greater move back accordingly
//  else {
//     		  if(t[i][j-1]>t[i-1][j]) {
//     			  j--;
//     		  }
//     		  else i--;
//     	  }
//       }
//and then again check for equality of characters for particualr and keep on adding char in result string then return result when reached i==0 or j==0
