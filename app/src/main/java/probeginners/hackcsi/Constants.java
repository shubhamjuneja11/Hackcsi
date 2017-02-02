package probeginners.hackcsi;

/**
 * Created by junejaspc on 2/2/17.
 */

public class Constants {
    public static String registered_users,from;

    public static void fun(){

    }
    public static String convert1(String a)
    {
        String from=a;
        from = from.replaceAll("\\.", "-1-");
        from = from.replaceAll("\\$", "-2-");
        from = from.replaceAll("#", "-3-");
        return from;

    }
    public static String convert2(String a)
    {
        String key=a;
        key=key.replaceAll("-1-",".");
        key=key.replaceAll("-2-","$");
        key=key.replaceAll("-3-","#");
        return key;
    }
}
