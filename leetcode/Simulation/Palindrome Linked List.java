import java.util.*;

class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> queue = new LinkedList<>();

        ListNode current = head; 
        while(current != null) {
            queue.add(current.val);
            current = current.next;
        }   

        while(queue.size() > 1) {
            if(queue.pollFirst() != queue.pollLast()) {
                return false;
            }
        }  
        return true;  
    }
}
