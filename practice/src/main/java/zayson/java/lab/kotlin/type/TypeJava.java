package zayson.java.lab.kotlin.type;

public class TypeJava {
    public static void main(String[] args) {
        int number = 10;
        long number2 = number;

        int number3 = 3;
        double result = number / (double) number3;
    }

    public static void printAgeIfPerson(Object obj) {
        if(obj instanceof PersonJava) {
            PersonJava person = (PersonJava) obj;
            System.out.println("person.getAge() = " + person.getAge());
        }
    }
}

