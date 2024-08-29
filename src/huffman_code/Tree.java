package huffman_code;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public void createTree(priorityQueue myQueue) {
        Node parentNode;

        while (myQueue.numCount > 1) {

            // Creating the new parent node and taking the first two items in PQ to its left and right and their frequency as its value
            parentNode = new Node(myQueue.front.frequency + myQueue.front.next.frequency);
            parentNode.left = myQueue.front;
            parentNode.right = myQueue.front.next;

            // Removing the first two items in the PQ via double remove method
            myQueue.doubleRemove();

            // Inserting our parent node back into the PQ
            myQueue.insert(parentNode);

        }   // While-loop exits when there is only one item left in the queue

        root = myQueue.front;

    }



    public String encode(char c){
        return encode(c, root, "");
    }


    private String encode(char key, Node currentNode, String code){

        if (currentNode == null){
            return null;
        }
        if (currentNode.character == key ){
            return code;
        }

        String leftSide = encode(key, currentNode.left, STR."\{code}0");
        if (leftSide != null) {
            return leftSide;
        }

        return encode(key, currentNode.right, STR."\{code}1");

    }


}






