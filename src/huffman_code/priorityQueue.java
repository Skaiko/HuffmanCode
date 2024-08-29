package huffman_code;

public class priorityQueue {

    Node front;
    int numCount;

    priorityQueue(){            // Empty priority queue list item
        front = null;
        numCount = 0;

    }

    public void insert(Node newNode){
        front = insert(front,newNode);

    }

    private Node insert(Node currentNode, Node newNode){

        if (currentNode == null) {
            currentNode = newNode;
            numCount++;
        } else if (newNode.frequency < currentNode.frequency) {
            newNode.next = currentNode;
            currentNode = newNode;
            numCount++;
        } else if (newNode.frequency == currentNode.frequency) {
            Node recentDupe = currentNode;  // Copy of the current node to represent the same frequencies it has with the new node inserted
            while (recentDupe.next != null && recentDupe.next.frequency == newNode.frequency) {
                recentDupe = recentDupe.next;
            }
            newNode.next = recentDupe.next;
            recentDupe.next = newNode;
            numCount++;
        } else { // Condition in which newNode.frequency > currentNode.frequency --> natural traversal
            currentNode.next = insert ( currentNode.next , newNode);
        }

        return currentNode;

    }

    public void doubleRemove(){
        if ( numCount == 0 ){
            System.out.println("Nothing to remove");
            return;
        }
        front = front.next.next;
        numCount-=2;
    }

}