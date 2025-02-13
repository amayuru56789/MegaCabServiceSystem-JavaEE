package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.UserBO;
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
}
