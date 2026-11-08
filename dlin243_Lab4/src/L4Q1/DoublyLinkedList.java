package L4Q1;
//ALL METHODS REQUIRED FOR LAB AT THE END OF THE NODE CLASS!!
import java.util.ArrayList;

public class DoublyLinkedList<E> {

    // ---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    public static class Node<E> {


        /** The element stored at this node */
        private E element;

        /** A reference to the preceding node in the list */
        private Node<E> prev;

        /** A reference to the subsequent node in the list */
        private Node<E> next;

        /**
         * Creates a node with the given element and next node.
         *
         * @param element the element to be stored
         * @param prev    reference to a node that should precede the new node
         * @param next    reference to a node that should follow the new node
         */
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        // public accessor methods
        /**
         * Returns the element stored at the node.
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that precedes this one (or null if no such node).
         * @return the preceding node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Update methods
        /**
         * Sets the node's previous reference to point to Node n.
         * @param p the node that should precede this one
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets the node's next reference to point to Node n.
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } // ----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header;

    /** Sentinel node at the end of the list */
    private Node<E> trailer;

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);      // create header
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the end of the list.
     * @param e the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }

    // public update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param e           the new element to add
     * @param predecessor node just before the location where the new element is inserted
     * @param successor   node just after the location where the new element is inserted
     */
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Returns the node containing the element e (or null if empty/not found).
     * @param e the element to search for
     * @return the node containing element e, or null
     */
    //Comment explaining method already above ^
    public Node<E> findNode(E e) {
        if(isEmpty())return null;
        Node<E> currentNode = header.getNext();
        //set current node to the beginning

        //end loop if the header reaches the end
        while(currentNode != trailer){
            //if at anytime the current node's e is equal to the one we're looking for, return it
            //and exit out of the loop
            if(currentNode.getElement().equals(e)) return currentNode;
            currentNode = currentNode.getNext();
        }

        //return null if nothing is found
        return null;
    }

    /**
     * Produces a string representation of the contents of the list.
     *
     * @return string representation of the list
     */
    @Override
    public String toString() {
        //declare new arraylist to store the outputs, declare a new node to represent the current node
        //in the linkedlist from the beginning
        ArrayList<E> output = new ArrayList<>();
        Node<E> currentNode = header.getNext();

        while(currentNode != trailer){
            output.add(currentNode.getElement());
            currentNode = currentNode.getNext();
            //iterate through the linkedlist, add elements to the array list
        }

        //return the output with arraylist
        return output.toString();
    }
}