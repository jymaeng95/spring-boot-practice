package zayson.java.lab.kotlin.grammer.lecture8;

public class Lec08Main {
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.println(str);
            }
        }
    }

    // 자바의 오버로딩
    public void repeat(String str, int num) {
        repeat(str, num, true);

    }

    public void repeat(String str) {
        repeat(str, 3);
    }
}
