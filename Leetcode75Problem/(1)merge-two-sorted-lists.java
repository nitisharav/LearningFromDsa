//Problem
//Link- https://leetcode.com/problems/merge-two-sorted-lists/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     //   ListNode temp1=list1;
      //  ListNode temp2=list2;
        ListNode fakeHead= new ListNode(-1);
        ListNode temp3= fakeHead;
        if(list1==null && list2==null){
            return null;
        }
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp3.next=list1;
                list1=list1.next;
                temp3=temp3.next;
                
            }
            
            else{
                temp3.next=list2;
                list2=list2.next;
                temp3=temp3.next;
            }
           
            
            
        }
          if (list1==null && list2!=null ){
            temp3.next=list2;
        }
             if (list2==null && list1!=null ){
            temp3.next=list1;
        }
       
        return fakeHead.next;
    }
}

//result - success
//========2nd attempt
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode fakehead= new ListNode(-1);
        ListNode temp=fakehead;
        
        while(list1!=null && list2!= null){
            if(list1.val<list2.val){
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }
            else {
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
        }
        
        if(list1==null && list2!=null){
            temp.next=list2;
        }
         if(list2==null && list1!=null){
            temp.next=list1;
        }
        return fakehead.next;
    }
}
//result - success
