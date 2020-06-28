package imburse.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;


public class Randomiser {

       public static String str;

public static String customRandomAlphanumericString() {
    String str;
        int length = 20;
        String digits = "0123456789";
        String specials = ".-_";
        String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + digits + specials;
        Random rnd = new Random();
        List<String> result = new ArrayList<>();
        Consumer<String> appendChar = s ->
                result.add("" + s.charAt(rnd.nextInt(s.length())));
        appendChar.accept(digits);
        appendChar.accept(specials);
        while (result.size() < length)
            appendChar.accept(all);
        Collections.shuffle(result, rnd);
         str = String.join("", result);
        System.out.println("Random string is" + str);

return str;
}

    public static String customRandomAlphanumericString(int noOfChars) {
        String str;
        int length = noOfChars;
        String digits = "0123456789";
        String specials = ".-_";
        String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + digits + specials;
        Random rnd = new Random();
        List<String> result = new ArrayList<>();
        Consumer<String> appendChar = s ->
                result.add("" + s.charAt(rnd.nextInt(s.length())));
        appendChar.accept(digits);
        appendChar.accept(specials);
        while (result.size() < length)
            appendChar.accept(all);
        Collections.shuffle(result, rnd);
        str = String.join("", result);
        System.out.println("Random string is" + str);

        return str;
    }




}

