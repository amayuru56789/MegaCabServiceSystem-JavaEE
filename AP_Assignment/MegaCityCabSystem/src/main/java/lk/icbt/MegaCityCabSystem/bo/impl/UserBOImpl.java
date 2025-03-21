package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.UserBO;
import lk.icbt.MegaCityCabSystem.dao.UserDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.UserDAOImpl;
import lk.icbt.MegaCityCabSystem.entity.User;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = new UserDAOImpl();

    @Override
    public User getUser(String user) {
        User user1 = userDAO.getUser(user);
        if (user1 != null){
            return userDAO.getUser(user);
        }else{
            return userDAO.getUser(user);
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
    public String findIdByUsername(String userName) {
        String id = userDAO.findIdByUsername(userName);
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
