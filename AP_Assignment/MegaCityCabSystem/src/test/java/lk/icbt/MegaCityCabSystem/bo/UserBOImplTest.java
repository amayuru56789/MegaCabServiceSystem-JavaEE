//package lk.icbt.MegaCityCabSystem.bo;
//
//import lk.icbt.MegaCityCabSystem.dao.UserDAO;
//import lk.icbt.MegaCityCabSystem.dao.UserDAOStub;
//import lk.icbt.MegaCityCabSystem.impl.UserBOImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.lang.reflect.Field;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class UserBOImplTest {
//
//    private UserBOImpl userBO;
//    private UserDAO userDAOStub;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        // Create an instance of UserBOImpl
//        userBO = new UserBOImpl();
//
//        // Create the stub implementation of UserDAO
//        userDAOStub = new UserDAOStub();
//
//        // Use reflection to inject the UserDAOStub into UserBOImpl
//        Field userDAOField = UserBOImpl.class.getDeclaredField("userDAO");
//        userDAOField.setAccessible(true); // Make the private field accessible
//        userDAOField.set(userBO, userDAOStub); // Set the field value
//    }
//
//    @Test
//    void testEqualityUser_ValidCredentials() {
//        // Act
//        boolean result = userBO.equalityUser("amayuru", "a");
//
//        // Assert
//        assertTrue(result, "Valid credentials should return true");
//    }
//
//    @Test
//    void testEqualityUser_InvalidCredentials() {
//        // Act
//        boolean result = userBO.equalityUser("john_doe", "wrong_password");
//
//        // Assert
//        assertFalse(result, "Invalid credentials should return false");
//    }
//
//    @Test
//    void testFindRoleByUsername_ValidUser() {
//        // Act
//        String role = userBO.findRoleByUsername("john_doe");
//
//        // Assert
//        assertEquals("customer", role, "Role should be 'customer' for username 'john_doe'");
//    }
//
//    @Test
//    void testFindRoleByUsername_UserNotFound() {
//        // Act & Assert
//        Exception exception = assertThrows(UserBOImpl.UserNotFoundException.class, () -> {
//            userBO.findRoleByUsername("amayuru");
//        });
//
//        assertEquals("User not found with username: unknown_user", exception.getMessage());
//    }
//
//    @Test
//    void testFindIdByUsername_ValidUser() {
//        // Act
//        Integer id = userBO.findIdByUsername("john_doe");
//
//        // Assert
//        assertEquals(1, id, "ID should be 1 for username 'john_doe'");
//    }
//
//    @Test
//    void testFindIdByUsername_UserNotFound() {
//        // Act & Assert
//        Exception exception = assertThrows(UserBOImpl.UserNotFoundException.class, () -> {
//            userBO.findIdByUsername("unknown_user");
//        });
//
//        assertEquals("User not found with username: unknown_user", exception.getMessage());
//    }
//
//    @Test
//    void testing() {
//
//    }
//}
