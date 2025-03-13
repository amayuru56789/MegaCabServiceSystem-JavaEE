package lk.icbt.MegaCityCabSystem.dao;

public interface UserDAO {
    boolean checkEqualityUser(String userName, String password);
    String findRoleByUsername(String userName);
    Integer findIdByUsername(String userName);
}
