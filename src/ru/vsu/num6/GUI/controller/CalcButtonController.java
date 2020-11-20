package ru.vsu.num6.GUI.controller;

import ru.vsu.num6.GUI.model.Model;
import ru.vsu.num6.GUI.utils.ArrayUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButtonController implements ActionListener {

    private JTextField inputArrText;
    private JTextField outputArrText;

    public CalcButtonController(JTextField inputArrText, JTextField outputArrText) {
        this.inputArrText = inputArrText;
        this.outputArrText = outputArrText;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String inputText = inputArrText.getText();
        int[] array = ArrayUtil.toIntArray(inputText);
        int sumElement = Model.getSumOfElements(array);
        outputArrText.setText(String.valueOf(sumElement));
    }
}
