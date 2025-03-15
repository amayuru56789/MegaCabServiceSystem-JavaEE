import lk.icbt.MegaCityCabSystem.util.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

    @Test
    void testAdd() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(5, 3);

        // Assert
        Assertions.assertEquals(8, result, "5 + 3 should equal 8");
    }

//    @Test
    void testSubtract() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.subtract(5, 3);

        // Assert
        Assertions.assertEquals(2, result, "5 - 3 should equal 2");
    }
}
