package huffman_code;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter a message: ");    //Take in user message
        Scanner input = new Scanner(System.in);
        String myMessage = input.nextLine();

        huffmanBuild.frequencyTable(myMessage);
        huffmanBuild.huffmanCreate();
        huffmanBuild.codeTable();

        System.out.println(); // Space
        String codedMessage = huffmanBuild.displayCodedMessage(myMessage);
        String decodedMessage = huffmanBuild.decode(codedMessage);
        System.out.println(STR."Coded message: \{codedMessage}");
        System.out.println(STR."Decoded Message: \{decodedMessage}");


        }
}