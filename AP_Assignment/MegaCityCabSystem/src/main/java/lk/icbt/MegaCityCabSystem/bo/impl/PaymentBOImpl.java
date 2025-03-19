package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.PaymentBO;
import lk.icbt.MegaCityCabSystem.dao.PaymentDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.PaymentDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.PaymentDTO;
import lk.icbt.MegaCityCabSystem.entity.Driver;
import lk.icbt.MegaCityCabSystem.entity.Payment;

import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = new PaymentDAOImpl();

    @Override
    public boolean makePayment(PaymentDTO paymentDTO) {
//        try {
//
//            return paymentDAO.addPayment(new Payment(
//                    paymentDTO.getPaymentId(),
//                    paymentDTO.getBookingId(),
//                    paymentDTO.getTotAmount()
//            ));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return false;
        try {
            // Calculate the total bill amount
            double distanceCharge = Double.parseDouble(paymentDTO.getDistance()) * paymentDTO.getRatePerKm();
            double waitingCharge = paymentDTO.getWaitingTime() * paymentDTO.getWaitingCharge();
            double subtotal = distanceCharge + waitingCharge + paymentDTO.getAdditionalCharges();
            double discountAmount = (paymentDTO.getDiscount() / 100) * subtotal;
            double totalAmount = subtotal - discountAmount;

            // Set the calculated total amount in the DTO
            paymentDTO.setTotAmount(totalAmount);

            // Save the payment in the database
            return paymentDAO.addPayment(new Payment(
                    paymentDTO.getPaymentId(),
                    paymentDTO.getBookingId(),
                    paymentDTO.getTotAmount()
            ));
        } catch (SQLException | ClassNotFoundException e) {
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
