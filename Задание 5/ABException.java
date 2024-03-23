public class ABException extends  Exception{
    public ABException(){
        super("Точки A, В не лежат по разные стороны от прямой а");
    }
}
