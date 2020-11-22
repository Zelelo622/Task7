package ru.vsu.num6.test;

import org.junit.*;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import ru.vsu.num6.GUI.logic.Logic;

import static org.junit.Assert.assertEquals;

public class TestLogic {

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CalcListener());
        core.run(TestLogic.class);
    }

    @Test
    public void testGetSumOfElements1() {
        Logic logic = new Logic();
        int actual = logic.getSumOfElements(new int[]{1000, 2, 3, 4, 0});
        assertEquals(9, actual);
    }

    @Test
    public void testGetSumOfElements2() {
        Logic logic = new Logic();
        int actual2 = logic.getSumOfElements(new int[]{0, 15, 1700, 121, 74, 197, 1600, -10, 0, -1});
        assertEquals(1992, actual2);
    }

    @Test
    public void testGetSumOfElements3() {
        Logic logic = new Logic();
        int actual3 = logic.getSumOfElements(new int[]{0, 1, 2, 3, 4});
        assertEquals(0, actual3);
    }

    @Test
    public void testGetSumOfElements4() {
        Logic logic = new Logic();
        int actual4 = logic.getSumOfElements(new int[]{10, 10, 10, 10, 10});
        assertEquals(0, actual4);
    }

    @Test
    public void testGetSumOfElements5() {
        Logic logic = new Logic();
        int actual5 = logic.getSumOfElements(new int[]{0, 1500, 0, -10, 115, -1548, -10500});
        assertEquals(-1443, actual5);
    }

    @Test
    public void testGetSumOfElements6() {
        Logic logic = new Logic();
        int actual6 = logic.getSumOfElements(new int[]{154, 2, -1051, 5, 10});
        assertEquals(2, actual6);
    }

    @Test
    public void testGetSumOfElements7() {
        Logic logic = new Logic();
        int actual7 = logic.getSumOfElements(new int[]{10, 0, 1, 2, 3, 4, 5, -1});
        assertEquals(15, actual7);
    }

    @Test
    public void testGetSumOfElements8() {
        Logic logic = new Logic();
        int actual8 = logic.getSumOfElements(new int[]{-10, 2, 3, 40, -20});
        assertEquals(0, actual8);
    }

    @Test
    public void testGetSumOfElements9() {
        Logic logic = new Logic();
        int actual9 = logic.getSumOfElements(new int[]{0, -1, 0, -2, 0});
        assertEquals(-1, actual9);
    }

    @Test
    public void testGetSumOfElements10() {
        Logic logic = new Logic();
        int actual10 = logic.getSumOfElements(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        assertEquals(45, actual10);
    }
}

class CalcListener extends RunListener {
    @Override
    public void testStarted(Description description) {
        System.out.println("Started: " + description.getMethodName());
    }

    @Override
    public void testFinished(Description description) {
        System.out.println("Finished: " + description.getMethodName());
        System.out.println("---------");
    }

    @Override
    public void testFailure(Failure failure) {
        System.out.println("Failed: " + " [" + failure.getMessage() + "]");
    }
}
