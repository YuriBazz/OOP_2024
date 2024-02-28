public class Box {
    private int width; // ширина коробки
    private int height; // высота коробки
    private int depth; // глубина коробки

    // Конструктор для создания клона объекта
    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // Конструктор, используемый при указании всех измерений
    Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    // Конструктор, используемый, когда ни одно из измерений не указано
    Box() {
        this(-1, -1, -1);
    }

    // Конструктор для создания куба
    Box(int len) {
        width = height = depth = len;
    }

    // вычисляем объём коробки
    int getVolume() {
        return width * height * depth;
    }

    // устанавливаем размеры коробки
    void setDim(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    String stringBox(){
        return "Коробка: "+width+", "+height+", "+ depth +".";
    }
}
