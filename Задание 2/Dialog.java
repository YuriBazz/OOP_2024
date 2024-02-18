import javax.swing.*;
public class Dialog {

    public static char charDialog(){
        String result = JOptionPane.showInputDialog("Введите символ: ");
        return result.charAt(0);
    }

    public static int kDialog(){
        String result = JOptionPane.showInputDialog("Введите число k: ");
        return Integer.parseInt(result);
    }

    public static int nDialog(){
        String result = JOptionPane.showInputDialog("Введите число n: ");
        return Integer.parseInt(result);
    }

    public static String stringDialog(){
        return JOptionPane.showInputDialog("Введите строку: ");
    }

}
