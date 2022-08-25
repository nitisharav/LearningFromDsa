//Problem 2
//Link- https://leetcode.com/problems/ransom-note/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map= new HashMap<Character, Integer>();
        int count=0;
        char rn[]= ransomNote.toCharArray();
        char mz[]=magazine.toCharArray();
       
        for (int i=0;i< mz.length;i++) {
        	if(map.containsKey(mz[i])) {
        		map.put(mz[i], map.get(mz[i])+1);
        	}
        	else if(!map.containsKey(mz[i])) {
        		map.put(mz[i], 1);
        	}
        }
        
        for (int i=0;i<rn.length;i++) {
        	if(map.containsKey(rn[i]) && map.get(rn[i])==1) {
        		map.remove(rn[i]);
        		count++;
        	}
        	if(map.containsKey(rn[i]) && map.get(rn[i])>1) {
        		map.put(rn[i], map.get(rn[i])-1);
        		count++;
        	}
        }
       return rn.length==count;
    }
}
