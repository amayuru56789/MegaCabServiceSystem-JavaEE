package lk.icbt.MegaCityCabSystem.bo;

import lk.icbt.MegaCityCabSystem.entity.User;

public interface UserBO {
    User getUser(String user);
    String findRoleByUsername(String userName);
    String findIdByUsername(String userName);
}
