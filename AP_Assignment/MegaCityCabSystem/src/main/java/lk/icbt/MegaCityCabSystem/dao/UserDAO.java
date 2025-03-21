package lk.icbt.MegaCityCabSystem.dao;

import lk.icbt.MegaCityCabSystem.entity.User;

public interface UserDAO {
    User getUser(String userName);
    String findRoleByUsername(String userName);
    String findIdByUsername(String userName);
}
