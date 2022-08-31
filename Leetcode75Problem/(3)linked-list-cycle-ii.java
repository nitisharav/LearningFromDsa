//Problem 3
//Link- https://leetcode.com/problems/linked-list-cycle-ii/submissions/

public class Solution {
    public ListNode detectCycle(ListNode head) {
       List<ListNode> list= new ArrayList<>();
        ListNode temp=head;
        if(head==null ) return null;
        while(!list.contains(temp)){
            if(temp.next==null) return null ;
            list.add(temp);
            temp=temp.next;
        }
        
        return temp;
    }
}

//Success
