package lk.icbt.MegaCityCabSystem.dao;

import lk.icbt.MegaCityCabSystem.entity.Customer;
import lk.icbt.MegaCityCabSystem.entity.Driver;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DriverDAO {

    ArrayList<Driver> getAllDriver() throws SQLException, ClassNotFoundException;
    boolean saveDriver(Driver entity) throws SQLException, ClassNotFoundException;
    boolean updateDriver(Driver entity) throws SQLException, ClassNotFoundException;
    boolean deleteDriver(String id) throws SQLException, ClassNotFoundException;
    boolean ifDriverExists(String id) throws SQLException, ClassNotFoundException;
    public Driver searchDriver(String driverID) throws SQLException, ClassNotFoundException;

}
