/**
 * SplitLinkedListInParts
 */
public class SplitLinkedListInParts {

    static ListNode[] split(ListNode head, int k) {
        ListNode arr[] = new ListNode[k];

        int n = size(head);
        int size = n / k, rem = n % k;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0);
            ListNode temp = dummy;

            for (int j = 0; j < size + (i < rem ? 1 : 0); j++) {
                temp.next = new ListNode(cur.val);
                temp = temp.next;
                cur = cur.next;
            }
            arr[i] = dummy.next;
        }
        return arr;
    }

    static int size(ListNode h) {
        int count = 0;
        while (h != null) {
            count++;
            h = h.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode ob = new ListNode(0);
        ListNode temp = ob;
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        display(ob);
        ListNode arr[] = split(ob, 4);
        for (ListNode n : arr)
            display(n);
    }

    static void display(ListNode ob) {
        while (ob != null) {
            System.out.print(ob.val + "-> ");
            ob = ob.next;
        }
        System.out.println();
    }

    static class ListNode {
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

}
