package zayson.java.lab.kotlin.grammer.lecture5;

public class Lec05Main {
    public static void main(String[] args) {

    }

    private void validateScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException(String.format("%s는 0보다 작을 수 없다.", score));
        }
    }
}
