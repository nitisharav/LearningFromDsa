//Problem 10
// Given an array Arr[] and a difference diff, find the number of subsets that array can be divided so that each the difference between the two subset is the given diff.

// Example1:
// Input:
// Arr[] : 1,1,2,3
// diff: 1
// Output: 3 .
//Top Down Approach

class Solution {

	public int CountSubsetWithGivenDiff(int arr[], int diff, int n) {
		int sumArr = 0;
		int sum = 0;
		for (int s : arr) {
			sumArr = sumArr + s;
		}
		sum = (diff + sumArr) / 2;
		return perfectSum(arr, n, sum);
	}

	public int perfectSum(int arr[], int n, int sum) {
		// Your code goes here
		// matrix making
		int[][] t = new int[n + 1][sum + 1];

		// initialisation
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (i == 0)
					t[i][j] = 0;
				if (j == 0)
					t[i][j] = 1;
			}
		}
		return isSubsetSumRes(n, arr, sum, t);

	}

	static int isSubsetSumRes(int N, int arr[], int sum, int t[][]) {
		// converting recursion into iteration
		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[i].length; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				} else
					t[i][j] = t[i - 1][j];

			}
		}

		return t[N][sum];

	}
}
//Learning 
//1.  Convert problem into (8)PerfectSumProblem
//2. Divide array as p1 and p2, with sum(p1) as s1 and sum(p2) as s2, 
//3. s1-s2= diff(given)
//4. s1+s2= sum(arr)
//5. Adding point 3 and point 4 , 2s1= diff+sum(arr);
//6. s1= (diff+sum(arr))/2;
//7. for given example, s1= (1+7)/2=4;
//8. This problem now converted to (8)PerfectSumProblem, count subset whose sum equal s1(4)
