class Box {
    private int value;
    Box(int value) {
        this.value = value;
    }
    void modify(Box other) {
        other.value = 50;
        other = new Box(100);
        other.value = 200;
    }
    int getValue() {
        return value;
    }
}
public class boxbox {
    public static void main(String[] args) {
        Box b1 = new Box(10);
        Box b2 = new Box(20);
        b1.modify(b2);
        System.out.println(
            b1.getValue() + ":" + b2.getValue()
        );
    }
}