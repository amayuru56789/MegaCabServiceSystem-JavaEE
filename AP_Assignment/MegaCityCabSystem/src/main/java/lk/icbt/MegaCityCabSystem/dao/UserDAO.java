package lk.icbt.MegaCityCabSystem.dao;

public interface UserDAO {
    boolean checkEqualityUser(String userName, String password);
    String findRoleByUsername(String userName);
    String findIdByUsername(String userName);
}
