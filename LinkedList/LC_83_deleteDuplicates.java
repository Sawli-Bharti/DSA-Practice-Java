/*
    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

    TC- O(n) where n is the number of nodes in the linked list
    SC- O(1) as we are not using any extra space
*/


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prevNode=head;
        if(head==null) return head;
        ListNode nextNode=head.next;
        while(nextNode!=null){
            if(prevNode.val==nextNode.val){
                prevNode.next=nextNode.next;
            }
            else prevNode=prevNode.next;
            nextNode=nextNode.next;
        }
        return head;
    }
}