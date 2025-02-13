package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.CabBO;
import lk.icbt.MegaCityCabSystem.dao.CabDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.CabDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CabDTO;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.entity.Cab;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class CabBOImpl implements CabBO {

    CabDAO cabDAO = new CabDAOImpl();

    @Override
    public ArrayList<CabDTO> getAllCab() {
        try {
            ArrayList<Cab> all = cabDAO.getAllCab();

            ArrayList<CabDTO> cabDTOS = new ArrayList<>();

            for (Cab cab : all) {
                cabDTOS.add(
                        new CabDTO(
                                cab.getCabID(),
                                cab.getModel(),
                                cab.getMileage(),
                                cab.getAvailableStatus(),
                                cab.getPrice(),
                                cab.getCapacity(),
                                "empty"
                        )
                );
            }

            return cabDTOS;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean addCab(CabDTO cabDTO) {

        try {

            return cabDAO.saveCab(new Cab(
                    cabDTO.getCabID(),
                    cabDTO.getModel(),
                    cabDTO.getMileage(),
                    cabDTO.getAvailableStatus(),
                    cabDTO.getPrice(),
                    cabDTO.getCapacity(),
                   "empty"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCab(CabDTO cabDTO) {
        try {

            return cabDAO.updateCab(new Cab(
                    cabDTO.getCabID(),
                    cabDTO.getModel(),
                    cabDTO.getMileage(),
                    cabDTO.getAvailableStatus(),
                    cabDTO.getPrice(),
                    cabDTO.getCapacity(),
                    "empty"
            ));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteCab(String id) {

        try {
            return cabDAO.deleteCab(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean ifCabExists(String id) {
        return false;
    }

    @Override
    public CabDTO searchCab(String cabID) {
        try {

            Cab searchCab = cabDAO.searchCab(cabID);
            if (searchCab != null){

                return new CabDTO(
                        searchCab.getCabID(),
                        searchCab.getModel(),
                        searchCab.getMileage(),
                        searchCab.getAvailableStatus(),
                        searchCab.getPrice(),
                        searchCab.getCapacity(),
                        "empty"
                );

            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new CabDTO();
    }
}
