package ru.vsu.num6.console;

public class TestCase {
    private final int[] array;
    private final int sum;

    public TestCase(int[] array, int sum) {
        this.array = array;
        this.sum = sum;
    }

    int[] getArray() {
        return array;
    }

    int getSum() {
        return sum;
    }
}
