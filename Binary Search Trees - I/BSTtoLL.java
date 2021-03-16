
class PairOfNodeElem {
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
}

public class Solution {

    /*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

    /*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */


    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        return constructLinkedListHelper(root).head;
    }
    private static PairOfNodeElem constructLinkedListHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            PairOfNodeElem pair = new PairOfNodeElem();
            return pair;
        }
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);
        PairOfNodeElem leftList = constructLinkedListHelper(root.left);
        PairOfNodeElem rightList = constructLinkedListHelper(root.right);
        PairOfNodeElem pair = new PairOfNodeElem();
        if (leftList.tail != null) {
            leftList.tail.next = newNode;
        }
        newNode.next = rightList.head;
        if (leftList.head != null) {
            pair.head = leftList.head;
        } else {
            pair.head = newNode;
        }
        if (rightList.tail != null) {
            pair.tail = rightList.tail;
        } else {
            pair.tail = newNode;
        }
        return pair;
    }
}
