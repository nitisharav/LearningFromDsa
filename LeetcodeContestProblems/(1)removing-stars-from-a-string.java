//Problem 1
//Link = https://leetcode.com/contest/weekly-contest-308/problems/removing-stars-from-a-string/
class Solution {
    public String removeStars(String s) {
        char ch[]= s.toCharArray();
        int count=0;
        String res="";
        for (int i=ch.length-1;i>=0;i--){
            if (ch[i]=='*'){
                count++;
                continue;
            }
            if(count>0 && ch[i]!='*') {
                count--;
                
                continue;
            }
            res= ch[i]+res;
        }
        return res;
    }
}
