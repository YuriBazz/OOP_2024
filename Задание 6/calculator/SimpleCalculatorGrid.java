package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleCalculatorGrid
{
    static private final AbstractValueParser[] valueParsers =
    new AbstractValueParser[]
            {
                new IntegerValueParser(),
                new RealValueParser(),
                new ComplexValueParser()
            };

    public static void main(String[] args)
    {

        JPanel windowContent = new JPanel();
        GridLayout gl = new GridLayout(6,2);
        windowContent.setLayout(gl);
        var firstOperandLabel = new JLabel("Операнд 1:");
        var firstOperandField = new JTextField(10);
        var secondOperandLabel = new JLabel("Операнд 2:");
        var secondOperandField = new JTextField(10);
        var operationsArray = new String[]
                {
                        "+",
                        "-",
                        "*",
                        "/"
                };
        var operationsBox = new JComboBox<String>(operationsArray);
        var operationsLabel = new JLabel("Операция:");
        var saveButton = new JButton("Сохранить");
        var newButton = new JButton("Новый");
        var resultButton = new JButton("Результат:");
        var resultField = new JTextField(10);
        var typesArray = new String[]
                {
                        "целые числа",
                        "вещественные числа",
                        "комплексные числа"
                };
        var typesBox = new JComboBox<String>(typesArray);
        var font = new Font("Arial", Font.BOLD, 20);
        firstOperandField.setFont(font);
        secondOperandField.setFont(font);
        firstOperandLabel.setFont(font);
        secondOperandLabel.setFont(font);
        resultField.setFont(font);
        resultButton.setFont(font);
        typesBox.setFont(font);
        operationsBox.setFont(font);
        operationsLabel.setFont(font);
        newButton.setFont(font);
        saveButton.setFont(font);


        windowContent.add(typesBox);
        windowContent.add(new JLabel());

        windowContent.add(firstOperandLabel);
        windowContent.add(firstOperandField);

        windowContent.add(operationsLabel);
        windowContent.add(operationsBox);

        windowContent.add(secondOperandLabel);
        windowContent.add(secondOperandField);

        windowContent.add(resultButton);
        windowContent.add(resultField);

        windowContent.add(newButton);
        windowContent.add(saveButton);

        var frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        frame.setSize(1024,512);
        frame.setVisible(true);

        resultButton.addActionListener(e ->
        {
            var typeIndex = typesBox.getSelectedIndex();
            var calculator = new Calculator(valueParsers[typeIndex]);
            String arg1 = firstOperandField.getText(),
                    arg2 = secondOperandField.getText(),
                    op = operationsBox.getSelectedItem().toString();
            try
            {
                resultField.setText(calculator.calculate(arg1, op, arg2));
            }
            catch(Exception exception)
            {
                resultField.setText(exception.getMessage());
            }
        });

        newButton.addActionListener(e ->
        {
            firstOperandField.setText("");
            secondOperandField.setText("");
            resultField.setText("");
        });

        saveButton.addActionListener(e->
        {
            var result = new File("output.txt");
            try
            {
                var writer = new BufferedWriter(new FileWriter(result));
                writer.write(firstOperandField.getText() +
                        " " + operationsBox.getSelectedItem().toString() +
                        " " + secondOperandField.getText() +
                        " = " + resultField.getText());
                writer.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            var saveFile = new JFileChooser(result);
            saveFile.showSaveDialog(frame);
        });
    }
}
