package lk.icbt.MegaCityCabSystem.bo;

import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.dto.DriverDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DriverBO {
    ArrayList<DriverDTO> getAllDriver();

    boolean addDriver (DriverDTO driverDTO);

    boolean updateDriver(DriverDTO driverDTO);

    boolean deleteDriver(String id);

    boolean ifDriverExists(String id);

    public DriverDTO searchDriver(String driverID);

}
