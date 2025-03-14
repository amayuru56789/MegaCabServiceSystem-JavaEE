package lk.icbt.MegaCityCabSystem.dao;

import lk.icbt.MegaCityCabSystem.dao.UserDAO;

public class UserDAOStub implements UserDAO {
    @Override
    public boolean checkEqualityUser(String userName, String password) {
        if ("john_doe".equals(userName) && "password123".equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public String findRoleByUsername(String userName) {
        if ("john_doe".equals(userName)) {
            return "customer";
        }
        return null;
    }

    @Override
    public Integer findIdByUsername(String userName) {
        if ("john_doe".equals(userName)) {
            return 1;
        }
        return null;
    }
}
