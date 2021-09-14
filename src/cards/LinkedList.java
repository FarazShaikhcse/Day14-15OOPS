package cards;

public class LinkedList {

	public Node head;

	/**
	 * @author farazshabbir this class represents a node of linked list
	 */
	private class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * @param data this parameter is the data to be stored in the node this method
	 *             adds a node with data to the end of the linked list
	 */
	public void add(final String data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;

		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	/**
	 * this method prints the content of the LL
	 */
	public void print() {
		Node temp = head;
		if (temp == null) {
			System.out.println("Underflow, Linked list is empty");
			return;
		}
		while (temp.next != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

}