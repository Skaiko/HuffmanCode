package huffman_code;

public class Node {

    char character;
    int frequency;

    Node left;  //Used for Huffman Node
    Node right; //Used for Huffman Node
    Node next; //Used for Priority Queue



    Node(char character, int frequency){        //Constructor Node that holds the character and its frequency.
        this.character = character;
        this.frequency = frequency;

        left = null;
        right = null;
        next = null;

    }

    Node(int frequency){                    //Constructor node for huffman tree to represent parent node
        this.frequency = frequency;

        left = null;
        right = null;
        next = null;

    }




}





