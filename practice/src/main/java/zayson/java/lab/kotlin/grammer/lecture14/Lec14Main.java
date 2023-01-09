package zayson.java.lab.kotlin.grammer.lecture14;

public class Lec14Main {
    public static void main(String[] args) {
        handleCountry(JavaCountry.KOREA);
    }

    private static void handleCountry(JavaCountry country) {
        if (country == JavaCountry.KOREA) {
            System.out.println("KOREAD");
        }

        if (country == JavaCountry.AMERICA) {
            System.out.println("US");
        }
    }
}
