package com.lab.java.zayson.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class ReflectionTest {
    public static void main(String[] args) throws Exception{
        methodInvoke();

        // 클래스 이름을 Class 객체로 벼환
        Class<? extends Set<String>> reflectionClass = null;
        try {
            //
            reflectionClass = (Class<? extends Set<String>>) Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("클래스를 찾을 수 없습니다.");
        }

        // 생성자를 얻는다.
        Constructor<? extends Set<String>> constructor = null;
        try {
            constructor = reflectionClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("매개변수가 없는 생성자를 찾을 수 없습니다.");
        }

        // 집합의 인스턴스를 만든다.
        Set<String> set = null;
        try {
            set = constructor.newInstance();
        } catch (InvocationTargetException e) {
            fatalError("생성자가 예외를 던졌습니다." + e.getCause());
        } catch (InstantiationException e) {
            fatalError("클래스를 인스턴스화할 수 없습니다.");
        } catch (IllegalAccessException e) {
            fatalError("생성자에 접근할 수 없습니다.");
        } catch (ClassCastException e) {
            fatalError("Set을 구현하지 않은 클래스입니다.");
        }

        // 생성된 인스턴스로 메서드 호출
        set.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(set);
    }

    private static void fatalError(String errorMessage) {
        System.err.println(errorMessage);
        System.exit(1);
    }

    private static void methodInvoke() throws Exception {
        Object obj = new Car("Genesis", 0);
        Class<Car> carClass = Car.class;

        // Object 타입이지만 Reflection을 통해서 메서드 정보를 가져와서 호출 가능
        Method method = carClass.getMethod("speedUp");
        method.invoke(obj, null);

        Method getSpeed = carClass.getMethod("getSpeed");
        int speed = (int) getSpeed.invoke(obj, null);

        System.out.println("speed = " + speed);
    }
}
