package zayson.java.lab.kotlin.nullable;

public class NullableJava {
    public static void main(String[] args) {
        checkNull1(null);
        checkNull2(null);
        checkNull3(null);

    }

    private static boolean checkNull1(String string) {
        // NPE 피하기
        if (string == null)
            throw new IllegalArgumentException("null");

        return string.startsWith("A");
    }

    private static Boolean checkNull2(String string) {
        if(string == null)
            return null;
        return string.startsWith("A");
    }

    private static boolean checkNull3(String string) {
        if(string == null)
            return false;
        return string.startsWith("A");
    }


}
