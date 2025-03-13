package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.DriverBO;
import lk.icbt.MegaCityCabSystem.dao.DriverDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.DriverDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CabDTO;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.dto.DriverDTO;
import lk.icbt.MegaCityCabSystem.entity.Cab;
import lk.icbt.MegaCityCabSystem.entity.Driver;

import java.sql.SQLException;
import java.util.ArrayList;

public class DriverBOImpl implements DriverBO {

    DriverDAO driverDAO = new DriverDAOImpl();
    @Override
    public ArrayList<DriverDTO> getAllDriver() {

        try {
            ArrayList<Driver> all = driverDAO.getAllDriver();

            ArrayList<DriverDTO> driverDTOS = new ArrayList<>();

            for (Driver driver : all) {
                driverDTOS.add(
                        new DriverDTO(
                                driver.getDriverID(),
                                driver.getDriverName(),
                                driver.getMobileNo(),
                                driver.getLicense(),
                                driver.getExperienceOfYear(),
                                driver.getEmail(),
                                driver.getAddress(),
                                driver.getStatus()
                        )
                );
            }

            return driverDTOS;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addDriver(DriverDTO driverDTO) {

        try {

            return driverDAO.saveDriver(new Driver(
                    driverDTO.getDriverID(),
                    driverDTO.getDriverName(),
                    driverDTO.getMobileNo(),
                    driverDTO.getLicense(),
                    driverDTO.getExperienceOfYear(),
                    driverDTO.getEmail(),
                    driverDTO.getAddress(),
                    driverDTO.getStatus()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDriver(DriverDTO driverDTO) {

        try {

            return driverDAO.updateDriver(new Driver(
                    driverDTO.getDriverID(),
                    driverDTO.getDriverName(),
                    driverDTO.getMobileNo(),
                    driverDTO.getLicense(),
                    driverDTO.getExperienceOfYear(),
                    driverDTO.getEmail(),
                    driverDTO.getAddress(),
                    driverDTO.getStatus()
            ));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean deleteDriver(String id) {
        try {
            return driverDAO.deleteDriver(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean ifDriverExists(String id) {
        return false;
    }

    @Override
    public DriverDTO searchDriver(String driverID) {

        try {

            Driver searchDriver = driverDAO.searchDriver(driverID);
            if (searchDriver != null){

                return new DriverDTO(
                        searchDriver.getDriverID(),
                        searchDriver.getDriverName(),
                        searchDriver.getMobileNo(),
                        searchDriver.getLicense(),
                        searchDriver.getExperienceOfYear(),
                        searchDriver.getEmail(),
                        searchDriver.getAddress(),
                        searchDriver.getStatus()
                );

            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new DriverDTO();

    }
}
