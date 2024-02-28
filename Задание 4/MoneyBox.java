public class MoneyBox extends HeavyBox{
    private int cost;

    // Конструирование клона объекта
    MoneyBox(MoneyBox ob) { // передача объекта конструктору
        super(ob);
        cost = ob.cost;
    }

    // Конструктор, используемый
    // при указании всех параметров
    MoneyBox(int w, int h, int d, int m, int c) {
        super(w, h, d, m);
        cost = c;
    }

    // Конструктор по умолчанию
    MoneyBox() {
        cost = -1;
    }

    // Конструктор для создания куба
    MoneyBox(int len, int m, int c) {
        super(len, m);
        cost = c;
    }

    @Override
    String stringBox() {
        return super.stringBox() + " Цена: " + cost + ".";
    }
}
