package modele;

import java.util.Scanner;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int entrerClavierInt() {
        int num = scanner.nextInt();
        String s = scanner.nextLine();
        return num;
    }

    public static String entrerClavierString() {
    	String s = scanner.nextLine();
    	scanner.reset();
        return s;
    }

}
