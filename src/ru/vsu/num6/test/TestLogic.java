package ru.vsu.num6.test;

import org.junit.Test;
import ru.vsu.num6.GUI.logic.Logic;

import static org.junit.Assert.assertEquals;

public class TestLogic {
    @Test
    public void testGetSumOfElements() {
        Logic logic = new Logic();
        int actual = logic.getSumOfElements(new int[]{1000, 2, 3, 4, 0});
        assertEquals(9, actual);
        int actual2 = logic.getSumOfElements(new int[]{0, 15, 1700, 121, 74, 197, 1600, -10, 0, -1});
        assertEquals(1992, actual2);
        int actual3= logic.getSumOfElements(new int[]{0, 1, 2, 3, 4});
        assertEquals(0, actual3);
        int actual4 = logic.getSumOfElements(new int[]{10, 10, 10, 10, 10});
        assertEquals(0, actual4);
        int actual5 = logic.getSumOfElements(new int[]{0, 1500, 0, -10, 115, -1548, -10500});
        assertEquals(-1443, actual5);
        int actual6 = logic.getSumOfElements(new int[]{154, 2, -1051, 5, 10});
        assertEquals(2, actual6);
        int actual7 = logic.getSumOfElements(new int[]{10, 0, 1, 2, 3, 4, 5, -1});
        assertEquals(15, actual7);
        int actual8 = logic.getSumOfElements(new int[]{-10, 2, 3, 40, -20});
        assertEquals(0, actual8);
        int actual9 = logic.getSumOfElements(new int[]{0, -1, 0, -2, 0});
        assertEquals(-1, actual9);
        int actual10 = logic.getSumOfElements(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        assertEquals(45, actual10);
    }
}
