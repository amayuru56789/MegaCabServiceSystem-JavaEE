package lk.icbt.MegaCityCabSystem.dao;

import lk.icbt.MegaCityCabSystem.entity.Cab;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CabDAO {

    ArrayList<Cab> getAllCab() throws SQLException, ClassNotFoundException;
    boolean saveCab(Cab entity) throws SQLException, ClassNotFoundException;
    boolean updateCab(Cab entity) throws SQLException, ClassNotFoundException;
    boolean deleteCab(String id) throws SQLException, ClassNotFoundException;
    boolean ifCabExists(String id) throws SQLException, ClassNotFoundException;
    public Cab searchCab(String cabID) throws SQLException, ClassNotFoundException;
}
