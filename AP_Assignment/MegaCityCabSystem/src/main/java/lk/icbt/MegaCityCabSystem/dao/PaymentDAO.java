package lk.icbt.MegaCityCabSystem.dao;

import lk.icbt.MegaCityCabSystem.dto.DriverDTO;
import lk.icbt.MegaCityCabSystem.dto.PaymentDTO;
import lk.icbt.MegaCityCabSystem.entity.Driver;
import lk.icbt.MegaCityCabSystem.entity.Payment;

import java.sql.SQLException;

public interface PaymentDAO {
    boolean addPayment(Payment entity) throws SQLException, ClassNotFoundException;
    boolean updatePayment(Payment entity) throws SQLException, ClassNotFoundException;

}
