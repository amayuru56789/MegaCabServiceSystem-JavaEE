package lk.icbt.MegaCityCabSystem.bo;

public interface UserBO {
    boolean equalityUser(String user, String password);
    String findRoleByUsername(String userName);
    Integer findIdByUsername(String userName);
}
