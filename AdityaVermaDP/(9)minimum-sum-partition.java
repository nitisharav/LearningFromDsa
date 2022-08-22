//Problem 9
//Link= https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1
//dp using top down

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    //List of S1 lesser than half range
	     int Range=0;
	     int mn= Integer.MAX_VALUE;
	    for(int x: arr){
	        Range=Range+x;
	    }
	   
	     List<Integer> list= new ArrayList<>();
	    
	   list= SubsetSum(arr,n ,Range);
	   for(int i=0;i<list.size();i++){
	      
	       mn=Math.min(mn,Range-2*list.get(i));
	   }
	   return mn;
	} 
	
	public List<Integer> SubsetSum(int arr[], int N,int sum){
	    List<Integer> list= new ArrayList<>();
	   
	   //initialisation
	   boolean t[][]= new boolean[N+1][sum+1] ;
	   for (int i=0;i<t.length;i++){
	       for (int j=0;j<t[i].length;j++){
	           if(i==0){
	               t[i][j]=false;
	           }
	           if (j==0){
	               t[i][j]=true;
	           }
	       }
	   }
	   
	   //code for iteration
	    for (int i=1;i<t.length;i++){
	       for (int j=1;j<t[i].length;j++){
	           if(arr[i-1]<=j){
	               t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j];
	           }
	           else {
	               t[i][j]=t[i-1][j];
	           }
	       }
	        
	    }
	   
	     for (int j=0;j<sum+1;j++){
	       
	       if(t[N][j]==true && j<=sum/2){
	        list.add(j);   
	       }
	     }
	   return list;
	}
}

////This solution passed 1020/1020 test case
//Learning
//1. divide array in two part p1 and p2 with sum s1 and s2, question asks to return minimumn absolute (s2-s1);
//2. If we sum s1 and s2 as Range, the s1 and s2 will lie within this Range;
//3.since s1+s2= Range, s2= Range -S1, 
//4. question asks to return minimumn absolute (s2-s1), so minimize (Range-s1)-s1= Range-2s1;
//5. example , Range=10,taking value of S1 {0,1,2,3,4,5}, s2{10,9,8,7,6,5} after mid range, s1 will start taking values of s2., so we will assign s1 only
//upto half range
//6. So s2 will always be greater , s2-s1 always positive , Range-2s1 always positive
//7.Now how we get s1,
//8. In subset sum(int arr[],int sum, int n) , last row of matrix= gives subset possible or not for arr[] with sum =0 to max value of sum
//9.similarly, subsetSum(int arr[],int Range, int n) , last row of matrix gives ssubset s1 possible or not for Range
//10.Now it becomes similar to point 5, so we take first half of last row of matrix, and insert Range(sum) for true into a list. This will give s1 list  for first half range
//11. store this as array list.
//Iterate through list, find minimum (Range-2s1). This will be answer
