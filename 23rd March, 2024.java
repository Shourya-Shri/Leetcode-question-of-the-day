/*You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.*/

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;

        ListNode curr=mid.next;
        mid.next=null;
        ListNode prev=null;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode left=head;
        ListNode right=prev;
        ListNode nextL,nextR;

        while(left!=null && right!=null){ 
            nextL=left.next; 
            left.next=right; 
            nextR=right.next; 
            right.next=nextL; 
 
            left=nextL; 
            right=nextR; 
        }
    }
}
