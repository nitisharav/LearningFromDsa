//Problem 20
//Link= https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
//dp using TopDown

Class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        
        //first find LCS
        char ch1[]= X.toCharArray();
        char ch2[]=Y.toCharArray();
        
        //Matrix initialisartion
        int t[][]= new int[m+1][n+1];
        
        // first row and first column automatically become 0 during matrix creation,
        
        //Matrix iteration
        for (int i=1;i<t.length;i++){
            for (int j=1;j<t[i].length;j++){
                if(ch1[i-1]==ch2[j-1]){
                    t[i][j]=1+t[i-1][j-1];
                }
                else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        //return total length-LCS
        return m+n-t[m][n];
    }
}
//This solution passed all test cases
//Learning
//1. Find LCS using (18)longest-common-subsequence
//Shortest super sequence= total length of both string -LCS
