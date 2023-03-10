package linked;

import java.util.*;

public class CharLinkedList {
	private CharNode head; // Empty if head and
	private CharNode tail; // tail are null

	public CharLinkedList() {
	}

	public CharLinkedList(String s) {
		for (int i = s.length() - 1; i >= 0; i--)
			insertAtHead(s.charAt(i));
	}

	public void insertAtHead(char ch) {
		assert hasIntegrity(); // Precondition

		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node; // Corner case: inserting into empty node

		assert hasIntegrity(); // Postcondition
	}

	public String toString() {
		String s = "";
		CharNode node = head;
		while (node != null) {
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}

	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no
	// loops,
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems.
	//
	boolean hasIntegrity() {
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null || tail == null)
			return head == null && tail == null;

		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;

		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null) {
			if (visitedNodes.contains(node))
				return false; // Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}

		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}

	public CharNode find(char ch) {
		CharNode current = this.head;
		// the while loop checks all until it reaches the result.
		while (current != null) {
			if (current.getData() == ch) {
				return current;
			} else {
				current = current.getNext();
			}
		}
		// Returns null if this doesn't reach a result by end of list.
		return null;
	}

	public void duplicate(char ch) throws IllegalArgumentException {
		// checks for emptiness
		if (head == null && tail == null) {
			return;
		}
		// checks if there is only 1 node.
		else if (head == tail && ch == head.getData()) {
			CharNode toBeAdded = new CharNode(ch);
			head.setNext(toBeAdded);
			this.tail = toBeAdded;
			return;
		}
		// The best-case scenario
		CharNode ref = this.find(ch);
		if (ref == null) {
			throw new IllegalArgumentException("Error: LinkedList does not contain " + "'" + ch + "'");
		}
		// checks if ch is the tail.
		else if (ref == this.tail) {
			CharNode toBeAdded2 = new CharNode(ch);
			ref.setNext(toBeAdded2);
			this.tail = toBeAdded2;

		}
		// Case that is between head and tail.
		else {
			CharNode temp = ref.getNext();
			CharNode toBeAdded3 = new CharNode(ch);
			ref.setNext(toBeAdded3);
			toBeAdded3.setNext(temp);
			return;
		}
	}
}
