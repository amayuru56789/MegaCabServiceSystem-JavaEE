package lk.icbt.MegaCityCabSystem.bo;

public interface UserBO {
    boolean equalityUser(String user, String password);
    String findRoleByUsername(String userName);
    String findIdByUsername(String userName);
}
