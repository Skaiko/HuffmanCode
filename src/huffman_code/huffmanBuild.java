package huffman_code;

public class huffmanBuild {

    static int[] freqArray = new int[256];
    static String[] codeTable = new String[256];
    static Tree huffmanTree = new Tree();
    static priorityQueue priorityQ = new priorityQueue();


    public static void frequencyTable(String myMessage) {
        
        for (char letter : myMessage.toCharArray()) {
            freqArray[letter]++;
        }

        System.out.println (" -== Frequency Table ==- ");

        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] > 0) {
                System.out.println(STR."\{(char) i} = \{freqArray[i]}");
            }
        }
    }


    public static void huffmanCreate() {
      for (int i = 0 ; i < freqArray.length; i++) {
        if (freqArray[i] > 0) {
            priorityQ.insert(new Node((char) i, freqArray[i]));
        }
        huffmanTree.createTree(priorityQ);
    }
}


    public static void codeTable(){
        System.out.println (" -== Code Table ==- ");

        for (int i = 0 ; i < freqArray.length ; i++){
            if (freqArray[i] > 0) {
                codeTable[i] = huffmanTree.encode( (char) i );
                System.out.println(STR."\{(char) i} = \{codeTable[i]}");
            }
        }
    }

    public static String displayCodedMessage(String myMessage){

        StringBuilder myCodedMessage = new StringBuilder();

        for (int i = 0 ; i < myMessage.length() ; i++ ){
            myCodedMessage.append(codeTable[myMessage.charAt(i)]);
        }

        return myCodedMessage.toString();
    }

    public static String decode(String myCodedMessage){
        return decode(myCodedMessage, huffmanTree.root);
    }

    private static String decode(String myCodedMessage, Node root){
        StringBuilder uncodedMessage = new StringBuilder();
        Node currentNode = root;

        for (int i = 0 ; myCodedMessage.length() > i ; i++){

            char bit = myCodedMessage.charAt(i);


            if (bit == '0'){
                currentNode = currentNode.left;
            } else if (bit == '1'){
                currentNode = currentNode.right;
            }


            assert currentNode != null;
            if (currentNode.left == null && currentNode.right == null){
                uncodedMessage.append(currentNode.character);
                currentNode = root;
            }
        }

        return uncodedMessage.toString();
    }

}
