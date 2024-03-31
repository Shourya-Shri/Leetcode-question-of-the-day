// Given the head of a linked list, remove the nth node from the end of the list and return its head.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            return head;
        }
        int i=1;
        int itof=sz-n;

        ListNode prev=head;
        while(i< itof){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;
    }
}
