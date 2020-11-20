package ru.vsu.num6.GUI.view;

import ru.vsu.num6.GUI.controller.CalcButtonController;
import ru.vsu.num6.GUI.controller.LoadFileButtonController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends JFrame {
    private final JButton calcButton = new JButton("Apply");
    private final JButton loadFileButton = new JButton("Open file");
    private final JTextField inputArrText = new JTextField();
    private final JLabel labelInput = new JLabel("Enter array elements (separators is , ;):");
    private final JLabel labelOutput = new JLabel("Sum:");
    private final JTextField outputArrText = new JTextField();
    private final JPanel rootPanel = new JPanel();

    public View() {
        super("Task7");
        setBounds(300, 150, 450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        calcButton.setBackground(new Color(119, 221, 119));
        calcButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loadFileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        rootPanel.setLayout(null);
        rootPanel.setBackground(new Color(229, 231, 233));
        labelInput.setBounds(5, 5, 250, 30);
        rootPanel.add(labelInput);

        inputArrText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent keyEvent) {
                char symbol = keyEvent.getKeyChar();
                if ((symbol < '0' || symbol > '9') && symbol != KeyEvent.VK_COMMA && symbol != KeyEvent.VK_SEMICOLON &&
                        symbol != KeyEvent.VK_SPACE) {
                    keyEvent.consume();
                }
            }
        });
        inputArrText.setBounds(255, 5, 150, 30);
        rootPanel.add(inputArrText);

        labelOutput.setBounds(5, 40, 50, 30);
        rootPanel.add(labelOutput);

        outputArrText.setBounds(55, 40, 85, 30);
        outputArrText.setEditable(false);
        rootPanel.add(outputArrText);

        calcButton.setBounds(175, 350, 100, 30);
        calcButton.addActionListener(new CalcButtonController(inputArrText, outputArrText));
        rootPanel.add(calcButton);

        loadFileButton.setBounds(40, 350, 100, 30);
        loadFileButton.addActionListener(new LoadFileButtonController(inputArrText, rootPanel));
        rootPanel.add(loadFileButton);

        getContentPane().add(rootPanel);
    }
}
