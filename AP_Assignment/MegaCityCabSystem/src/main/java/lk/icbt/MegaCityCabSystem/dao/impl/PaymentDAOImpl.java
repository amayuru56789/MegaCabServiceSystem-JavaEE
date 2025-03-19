package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.PaymentDAO;
import lk.icbt.MegaCityCabSystem.dto.DriverDTO;
import lk.icbt.MegaCityCabSystem.dto.PaymentDTO;
import lk.icbt.MegaCityCabSystem.entity.Payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean addPayment(Payment entity) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("insert into Payment values(?,?,?)");
        pstm.setObject(1, entity.getPaymentId());
        pstm.setObject(2, entity.getBookingId());
        pstm.setObject(3, entity.getTotAmount());
//        pstm.setObject(4, entity);

        if (pstm.executeUpdate()>0){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean updatePayment(Payment entity) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");

        PreparedStatement pstm = con.prepareStatement("update Payment set bookingId=?, totalAmount=?, discount=? where paymentId=?");
        pstm.setObject(1, entity.getBookingId());
        pstm.setObject(2, entity.getTotAmount());
        pstm.setObject(3, entity.getPaymentId());

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }

    }
}
