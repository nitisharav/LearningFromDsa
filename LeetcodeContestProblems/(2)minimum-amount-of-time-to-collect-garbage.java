//problem 2
//Link- https://leetcode.com/contest/weekly-contest-308/problems/minimum-amount-of-time-to-collect-garbage/
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int sum=0;
        int res=0;
        int index[]= new int [3];
        index[0]=index[1]=index[2]= -1;
        for (int i=0;i<garbage.length;i++){
            sum= sum+garbage[i].length();
            if(garbage[i].contains("M")){
                index[0]=i;
            }
                if(garbage[i].contains("P")){
                index[1]=i;
            }
                    if(garbage[i].contains("G")){
                index[2]=i;
            }
        }
        
        for(int i=1;i<travel.length;i++){
            travel[i]+=travel[i-1];
           
        }
        
         for(int i=0;i<index.length;i++){
            if(index[i]> 0){
                res=res+travel[index[i]-1];
                
            }
              System.out.println(index[i]);
        }
        
                       
                       
                       
        
        return res+sum;
    }
}
