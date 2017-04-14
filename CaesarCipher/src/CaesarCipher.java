import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String inStr = "";
		String outStr = "";
		int key = 13;
		
		System.out.println("Enter a string for encoding");
		inStr = scan.nextLine();
		
		for (int i = 0; i < inStr.length(); i++) {
			char inChar = inStr.charAt(i);
			char outChar = inChar;
			if (inChar >= 'A' && inChar <= 'Z') {
				outChar = (char)((inChar - 'A' + key ) % 26 + 'A');
			}
			else if (inChar >= 'a' && inChar <= 'z') {
				outChar = (char)((inChar - 'a' + key ) % 26 + 'a');
			}
			outStr += outChar;
		}
        System.out.println(outStr);
	}
}
