package lk.icbt.MegaCityCabSystem;

import lk.icbt.MegaCityCabSystem.util.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAdd() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(5, 3);

        // Assert
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    void testSubtract() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.subtract(5, 3);

        // Assert
        assertEquals(2, result, "5 - 3 should equal 2");
    }
}
