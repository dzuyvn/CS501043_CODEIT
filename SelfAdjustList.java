// Read names into a self-adjusting list.
// In a search operation, whenever a name is found, it is moved
// to the front of the list.
// You are not to modify this program.

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class SelfAdjustList {
	public static void main(String[] args) 
	                       throws NoSuchElementException, IOException {
		MyLinkedList <String> names = new MyLinkedList <String>();
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("in.txt"));
		
		readNames(sc, names);
		System.out.println("Original list: ");
		System.out.println(names); 

		double aveProbes = searchOperations(sc, names);
		System.out.printf("Average number of probes = %.2f\n", aveProbes);

		System.out.println("Final list: ");
		System.out.println(names); 
	}

	// To read in integers into the linked list 
	public static void readNames(Scanner sc, MyLinkedList <String> list) {

		// Assume that numOfNames > 0
		int numOfNames = sc.nextInt();
		for (int i=0; i<numOfNames; i++) {
			list.addFirst(sc.next());
		}
	}
	
	// To read in a number of search queries 
	// and compute the average number of probes required.
	public static double searchOperations(Scanner sc, MyLinkedList <String> list) {
		int numOfSearch = sc.nextInt(); // assume numOfSearch > 0
		int totalProbes = 0;
		String name;

		for (int i=0; i<numOfSearch; i++) {
			totalProbes += list.search(sc.next());
			//System.out.println(list);
		}
		return (double) totalProbes/numOfSearch;
	}

}

/******* Class definition for ListNode *******/
class ListNode <E> {
	/* data attributes */
	private E element;
	private ListNode <E> next;

	/* constructors */
	public ListNode() {
		this.next = null;
	}

	public ListNode(E element) { 
		this(element, null); 
	}

	public ListNode(E element, ListNode <E> next) { 
		this.element = element; 
		this.next = next; 
	}

	public ListNode <E> getNext() {
		return this.next;
	}

	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode <E> next) {
		this.next = next;
	}
}


/******* Class definition for MyLinkedList *******/
class MyLinkedList <E> {

	// Data attributes
	private ListNode <E> head = null;
	private int numNodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (numNodes == 0);  // or return (head == null);
	}

	// Return number of nodes in list.
	public int size() { 
		return numNodes; 
	}

	// Return value in the first node.
	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("List is empty!");
		else 
			return head.getElement();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(E item) {
		for (ListNode <E> curr = head; curr != null; curr = curr.getNext())
			if (curr.getElement().equals(item)) 
				return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(E item) {
		head = new ListNode <E> (item, head);
		numNodes++;
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("Can't remove from an empty list!");
		else { 
			ListNode <E> first = head;
			head = head.getNext();
			numNodes--;
			return first.getElement();
		}
	}

	// Return string representation of list.
	public String toString() {
		// Fill in the code
		if (head == null) return "[]";

        String res = "[";
        res += head.getElement();
        ListNode<E> curr = head.getNext();
 
        while (curr != null) {
            res += ", " + curr.getElement();
            curr = curr.getNext();
        }
 
        return res + "]";
	}

	// Return the number of probes to search item in list.
	public int search(E item) {
		// Fill in the code
		if (head == null) return 0;
		if (head.getElement().equals(item)) return 1;

		ListNode<E> p = new ListNode<E>();
		ListNode<E> cur = head;

		p.setNext(head);
		boolean done = false;

		int cnt = 0;
		while (p.getNext() != null) {
			cur = p.getNext();
			++cnt;
			if (cur.getElement().equals(item)) {
				done = true;
				break;
			}

			p = cur;
		}

		if (!done) {
			//System.out.println(numNodes);
			return numNodes;
		}

		p.setNext(cur.getNext());
		numNodes--;
		addFirst(cur.getElement());
		
		//System.out.println(cnt);

		return cnt;
	}
}
