import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Message mess = new Message();
        System.out.println(mess.line);
        mess = new Message (str);
        System.out.println(mess.line);
        System.out.printf("Перевернутая строка: %s\n\r", mess.reverse());
        System.out.printf("Количество слов: %d \n\r", mess.amountOfWords());
        var symbol = Dialog.charDialog();
        System.out.printf("Количество вхождений символа %s: %d \n\r",symbol, mess.amountOfSymbol(symbol));
        System.out.printf("Номер: %s\n\r", mess.number());
        var k = Dialog.kDialog();
        var n = Dialog.nDialog();
        var s = Dialog.stringDialog();
        System.out.printf("Новая строка: %s", mess.knSubstring(k,n,s));
    }
}