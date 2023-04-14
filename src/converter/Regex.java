package converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Pattern p = Pattern.compile("LXXXXVI");

        Matcher m = p.matcher("LXVI");
        Matcher m2 = p.matcher("LXXXVI");
        Matcher m3 = p.matcher("LX");
        Matcher m4 = p.matcher("LXIIII");

        boolean b = m.matches();
        System.out.println(b);
        b = m2.matches();
        System.out.println(b);
        b = m3.matches();
        System.out.println(b);
        b = m4.matches();
        System.out.println(b);
    }
}
