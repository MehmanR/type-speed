package utils;

import java.util.Scanner;

public class InputUtil {

    public static String requeirString (String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        return sc.nextLine();
    }

}
