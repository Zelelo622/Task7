package ru.vsu.num6.GUI.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadFileButtonController implements ActionListener {

    JTextField inputArrText;
    JPanel rootPanel;

    public LoadFileButtonController(JTextField inputArrText, JPanel rootPanel) {
        this.inputArrText = inputArrText;
        this.rootPanel = rootPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.showOpenDialog(rootPanel);
        File file = fileChooser.getSelectedFile();
        try {
            FileReader fileReader = new FileReader(file);
            char[] array = new char[(int) file.length()];
            fileReader.read(array);
            inputArrText.setText(String.valueOf(array));
        } catch (IOException event) {
            inputArrText.setText("An error occurred with the file!");
        }
    }
}
