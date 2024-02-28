public class BoxTest {
    public static void main(String[] args) {
        Box box1 = new Box(100, 200, 100);
        Box cloneBox = new Box(box1);
        int vol = cloneBox.getVolume();
        System.out.println("Объем: "+vol);
        Box pBox = new Box();
        System.out.println(pBox.stringBox());

        HeavyBox box = new HeavyBox(15, 10, 20, 5);
        System.out.println(box.stringBox());
        vol = box.getVolume();
        System.out.println("Объем: "+vol);

        MoneyBox boxM = new MoneyBox (20, 5, 100);
        System.out.println(boxM.stringBox());
        vol = boxM.getVolume();
        System.out.println("Объем: "+vol);
    }

}
