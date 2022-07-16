package zayson.java.lab.steram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxStream {
    public static void main(String[] args) {
        int[] ints = {1, 3, 6, 5, 1, 2, 5};

        IntStream intStream = Arrays.stream(ints);
        Stream<Integer> boxedStream = intStream.boxed();

    }
}
