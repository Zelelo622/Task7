package ru.vsu.num6.GUI;

import ru.vsu.num6.GUI.view.View;
import ru.vsu.num6.Test.TestLogic;

public class MainGUI {

    public static void main(String[] args) {
        TestLogic testLogic = new TestLogic();
        testLogic.testGetSumOfElements();
        View app = new View();
        app.setVisible(true);
    }
}
