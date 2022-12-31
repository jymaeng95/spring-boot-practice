package zayson.java.lab.kotlin.grammer.lecture2;

public class Lec02Main {
    public boolean startsWithV1(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null이 들어왔습니다");
        }

        return str.startsWith("A");
    }

    public Boolean startsWithV2(String str) {
        if (str == null) {
            return null;
        }

        return str.startsWith("A");
    }

    public boolean startsWithV3(String str) {
        if (str == null) {
            return false;
        }

        return str.startsWith("A");
    }
}
