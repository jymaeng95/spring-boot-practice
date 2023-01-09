package zayson.java.lab.kotlin.grammer.lecture13;

public class JavaHouse {
    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address, LivingRoom livingRoom) {
        this.address = address;
        this.livingRoom = livingRoom;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    // static 클래스
    public static class LivingRoom {
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }
    }
}
