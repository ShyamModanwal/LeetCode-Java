/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0){
            return null;
        }
        return mergekhelper(lists , 0 , lists.length-1);

            }

            private ListNode mergekhelper(ListNode[] lists , int start ,int end){
                if (start == end){
                    return lists[start];
                }
                if(start + 1 == end){
                    return merge2List(lists[start], lists[end]);
                }
                int mid = start + (end - start)/2;
                ListNode left = mergekhelper(lists , start , mid);
                ListNode right = mergekhelper(lists, mid + 1 , end);
                return merge2List(left, right);
            }
            private ListNode merge2List(ListNode l1 , ListNode l2){
                ListNode dummy = new ListNode(0);
                ListNode curr = dummy;

                while (l1 != null && l2 != null)
                {
                    if (l1.val <= l2.val){
                        dummy.next = l1;
                        l1 = l1.next;
                    }
                    else {
                        dummy.next = l2;
                        l2 = l2.next;
                    }
                    dummy = dummy.next;
                }
                dummy.next = (l1 == null) ? l2 : l1;
                return curr.next;
            }
}