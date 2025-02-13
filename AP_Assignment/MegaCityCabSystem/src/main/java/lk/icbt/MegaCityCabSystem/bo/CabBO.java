package lk.icbt.MegaCityCabSystem.bo;

import lk.icbt.MegaCityCabSystem.dto.CabDTO;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CabBO {

    ArrayList<CabDTO> getAllCab();

    boolean addCab (CabDTO cabDTO);

    boolean updateCab(CabDTO cabDTO);

    boolean deleteCab(String id);

    boolean ifCabExists(String id);

    public CabDTO searchCab(String cabID);
}
