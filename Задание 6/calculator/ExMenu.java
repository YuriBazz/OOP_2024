package calculator;
//ÈÑÕÎÄÍÈÊ ÍÀ ÏÎÑÌÎÒÐÅÒÜ
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExMenu {
    private JFrame frame;
    public void go()
    {
        frame = new JFrame("Menu");
        var menuBar = new JMenuBar();
        var fileMenu = new JMenu("File");
        var saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.setSize(500,600);
        frame.setVisible(true);

        saveMenuItem.addActionListener(e ->
        {
            var fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
        });
    }

    private void safeFile(File file)
    {
        try
        {
            var writer = new BufferedWriter(new FileWriter(file));
            writer.write("data");
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println("frik");
        }
    }

}
