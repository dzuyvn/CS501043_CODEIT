import java.util.*;
import java.lang.*;

public class MySortedLinkedList <E extends Comparable <E>> {

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

	// Add item to the list, maintaining the order.
	public void addOrdered(E item) throws NullPointerException {
        // Fill in the code
        if (head == null) {
            addFirst(item);
            return;
        }

        if (head.getElement().compareTo(item) > 0) {
            addFirst(item);
            return;
        }

        ListNode<E> curr = new ListNode(item, head);
        while (curr.getNext() != null) {
            ListNode<E> p = curr.getNext();
            if (p.getElement().compareTo(item) > 0) {
                break;
            }

            if (curr.getNext() != null) 
                curr = curr.getNext();
        }
        
        ListNode<E> newNode = new ListNode<E>(item, curr.getNext());
        curr.setNext(newNode);
        numNodes++;
	}
}

class ListNode <E> {
	/* data attributes */
	private E element;
	private ListNode <E> next;

	/* constructors */
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