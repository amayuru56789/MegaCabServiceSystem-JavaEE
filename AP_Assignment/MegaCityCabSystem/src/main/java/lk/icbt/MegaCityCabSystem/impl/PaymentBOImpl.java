package lk.icbt.MegaCityCabSystem.impl;

import lk.icbt.MegaCityCabSystem.PaymentBO;
import lk.icbt.MegaCityCabSystem.dao.PaymentDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.PaymentDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.PaymentDTO;
import lk.icbt.MegaCityCabSystem.entity.Payment;

import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = new PaymentDAOImpl();

    @Override
    public boolean makePayment(PaymentDTO paymentDTO) {
        try {

            return paymentDAO.addPayment(new Payment(
                    paymentDTO.getPaymentId(),
                    paymentDTO.getBookingId(),
                    paymentDTO.getTotAmount()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean changePayment(PaymentDTO paymentDTO) {
        try {

            return paymentDAO.updatePayment(new Payment(
                    paymentDTO.getPaymentId(),
                    paymentDTO.getBookingId(),
                    paymentDTO.getTotAmount()
            ));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
