package linked_list.oddEven.solution2;

class ListNode {
    int val;
  ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head==null||head.next==null||head.next.next==null)
            return head;

        ListNode oddHead=null,oddTail=null,evenHead=null,evenTail=null;
        ListNode n=head;
        int count=1;
        while(n!=null){
            if(count%2==1){
                //addToOdd
                if(oddHead==null)
                    oddHead=oddTail=n;
                else{
                    oddTail.next=n;
                    oddTail=oddTail.next;
                }
            }
            else{
                //addToEven
                if(evenHead==null){
                    evenTail=evenHead=n;
                } else{
                    evenTail.next=n;
                    evenTail=evenTail.next;
                }
            }
            count++;
            n=n.next;
        }
        evenTail.next=null;
        oddTail.next=evenHead;
        return oddHead;
    }
}