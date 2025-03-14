package lk.icbt.MegaCityCabSystem.impl;

import lk.icbt.MegaCityCabSystem.UserBO;
import lk.icbt.MegaCityCabSystem.dao.UserDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.UserDAOImpl;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean equalityUser(String user, String password) {
        boolean equal = userDAO.checkEqualityUser(user, password);
        if (equal){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String findRoleByUsername(String userName) {
        String roleByUsername = userDAO.findRoleByUsername(userName);

        // If role is not found, throw an exception
        if (roleByUsername == null) {
            throw new UserNotFoundException("User not found with username: " + userName);
        }

        return roleByUsername;
    }

    @Override
    public Integer findIdByUsername(String userName) {
        Integer id = userDAO.findIdByUsername(userName);
        // If ID is not found, throw an exception
        if (id == null) {
            throw new UserNotFoundException("User not found with username: " + userName);
        }

        return id;
    }

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
