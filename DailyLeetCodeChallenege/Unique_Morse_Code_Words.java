//Unique Morse Code Words
//Link= https://leetcode.com/problems/unique-morse-code-words/
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String pattern  []={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
       System.out.println('a'-97);
        
        for (int i=0;i<words.length;i++){
            char ch[]= words[i].toCharArray();
            String s="";
            for (char c:ch){
                int x=c-97;
                s=s+pattern[x];
            }
            words[i]=s;
        }
        Set<String> unq=new HashSet<>(Arrays.asList(words));
        
        return unq.size();
    }
}

//Learning
// 1. From Array to hashSet in one line
  //  Set<String> unq=new HashSet<>(Arrays.asList(words));
   
