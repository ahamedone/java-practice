class PalindromeLinkedList {

    public static boolean palindrome(LinkedListNode head){

        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        LinkedListNode revertData = reverseLinkedList(slow);

        boolean check = compareTwoHalves(head, revertData);

        reverseLinkedList(revertData);

        return check;

    }

    public static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }


        }
        return true;
    }

	// Driver code
    public static void main( String args[] ) {
        
        int[][] input={
          {2, 4, 6, 4, 2},
          {0, 3, 5, 5, 0},
          {9, 27, 4, 4, 27, 9},
          {5, 4, 7, 9, 4, 5},
          {5, 10, 15, 20, 15, 10, 5}
          };
        
        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tLinked list:  ");
            printListWithForwardArrow(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = palindrome(list.head);
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        
    }

	public static LinkedListNode reverseLinkedList(LinkedListNode slowPtr){
		LinkedListNode prev = null;
		LinkedListNode next = null;    
		LinkedListNode curr = slowPtr;  
		
		while (curr != null)   
		{  
		next = curr.next;  
		curr.next = prev;  
		prev = curr;  
		curr = next;  
		}    
		return prev;  
	}

    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            } else{
                // if this is the last node, print null at the end
                System.out.print(" → null \n ");
            }
        }
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    public LinkedListNode head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }    
}