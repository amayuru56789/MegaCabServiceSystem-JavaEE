package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.PaymentBO;
import lk.icbt.MegaCityCabSystem.bo.impl.PaymentBOImpl;
import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.BookingCommonDTO;
import lk.icbt.MegaCityCabSystem.dto.PaymentDTO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.security.sasl.SaslException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "PaymentServlet", urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServlet {

    PaymentBO paymentBO = new PaymentBOImpl();

    BookingDAOImpl bookingDAO = new BookingDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        String bookingNumber = req.getParameter("bookingNumber");

        try {
            BookingCommonDTO booking = bookingDAO.getBookingDetailsBaseBookId(bookingNumber);

            if (booking != null) {
                // Convert booking details to JSON
                JsonObject jsonResponse = Json.createObjectBuilder()
                        .add("customerName", booking.getCustomerName())
//                        .add("distance", booking.getDistance())
//                        .add("ratePerKm", booking.getRatePerKm())
//                        .add("waitingTime", booking.getWaitingTime())
//                        .add("waitingCharge", booking.getWaitingCharge())
//                        .add("additionalCharges", booking.getAdditionalCharges())
//                        .add("discount", booking.getDiscount())
                        .build();

                // Send JSON response
                resp.getWriter().write(jsonResponse.toString());
            } else {
                // Send empty response if no booking is found
                resp.getWriter().write("{}");
            }
        } catch (SaslException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        String bookingNumber = jsonObject.getString("bookingNumber");
        String distance = jsonObject.getString("distance");
        double ratePerKm = Double.parseDouble(jsonObject.getString("ratePerKm"));
        double waitingTime = Double.parseDouble(jsonObject.getString("waitingTime"));
        double waitingCharge = Double.parseDouble(jsonObject.getString("waitingCharge"));
        double additionalCharges = Double.parseDouble(jsonObject.getString("additionalCharges"));
        double discount = Double.parseDouble(jsonObject.getString("discount"));

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId("PAY-" + UUID.randomUUID().toString()); // Generate a unique payment ID
        paymentDTO.setBookingId(bookingNumber);
        paymentDTO.setDistance(distance);
        paymentDTO.setRatePerKm(ratePerKm);
        paymentDTO.setWaitingTime(waitingTime);
        paymentDTO.setWaitingCharge(waitingCharge);
        paymentDTO.setAdditionalCharges(additionalCharges);
        paymentDTO.setDiscount(discount);

        boolean isSaved = paymentBO.makePayment(paymentDTO);
        if (isSaved) {
            JsonObject responseJson = Json.createObjectBuilder()
                    .add("status", "success")
                    .add("message", "Payment added successfully!")
                    .build();
            writer.write(responseJson.toString());
        } else {
            JsonObject responseJson = Json.createObjectBuilder()
                    .add("status", "error")
                    .add("message", "Payment couldn't added !")
                    .build();
            writer.write(responseJson.toString());
        }
    }
}
