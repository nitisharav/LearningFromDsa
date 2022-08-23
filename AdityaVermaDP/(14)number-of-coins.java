
//problem 14
//Link= https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
//TopDown Approach

class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // matrix initialisation
	    int infinity=Integer.MAX_VALUE-1;
	    int t[][]= new int[M+1][V+1];
	    for (int i=0;i<t.length;i++){
	        for (int j=0;j<t[i].length;j++){
	            if(i==0){
	                t[i][j]=infinity;
	            }
	           
	            if(j==0){
	                t[i][j]=0;
	            }
	             if(i==1 && j!=0 && j%coins[0]==0){
	                t[i][j]=j/coins[0];
	            }
	             if(i==1 && j!=0 && j%coins[0]!=0){
	                t[i][j]=infinity;
	            }
	        }
	    }
	    
	    // iteration
	    for (int i=2;i<t.length;i++){
	        for (int j=1;j<t[i].length;j++){
	          if(coins[i-1]<=j){
	              t[i][j]= Math.min(t[i][j-coins[i-1]]+1, t[i-1][j]);
	          }  
	          else t[i][j]= t[i-1][j];
	        }
	        
	    }
	    
	    if (t[M][V]==infinity) return -1;
	    
	   return t[M][V]; 
	} 
}
//This solution passed 212/212 test case
//Learning
//1. Similar to knapsack unbound
//2. make matrix , define int infinity=Integer.MAX_VALUE-1 , it resembles infinity
//3. wt[]--coins[], val--- ignored, W-- sum
//4. minimum count of coins when when coins.size=0, sum>0= infinity== Int.max-1,  It means target sum will never be reached using multiple occurance of available coin
//5. If sum =4, we have coin value 3 only , it will never become 4 , so we take indinity
//6.If sum =3, we have coin value 3 only , it will never become 3 by using 1 coin.
//7. Thats why we also initialise for coin.size ==1
// 8. In iteration , we start from i==2, j==1, as i==0,1 and j==0 already initialised
//9.  From unbound Knapsack t[i][j]= Math.max(t[i][j-coins[i-1]]+val[i-1], t[i-1][j]) becomes  t[i][j]= Math.min(t[i][j-coins[i-1]]+1, t[i-1][j]);
//10 Instead of value , we are using 1, if it included coins count increase,
//11. we return minimum of (include item, exclude item)
