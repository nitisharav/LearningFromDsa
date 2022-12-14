
//Problem 1
//Link =https://leetcode.com/problems/first-unique-character-in-a-string/

class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}

//Learning
//count.put(c, count.getOrDefault(c, 0) + 1);
//getOrDefault(key, default value)=Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
