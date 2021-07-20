package Algorithm.study.first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {
    int INIT = 100;
    FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<>(INIT);

    @Test
    void isEmpty() {
        assertTrue(fixedCapacityStack.isEmpty());
    }

    @Test
    void size() {
        assertEquals(fixedCapacityStack.size(), 0);
    }

    @Test
    void push() {
        fixedCapacityStack.push("a");
        assertEquals(fixedCapacityStack.size(), 1);
    }

    @Test
    void pop() {
        fixedCapacityStack.push("a");
        assertEquals(fixedCapacityStack.pop(), "a");
    }
}