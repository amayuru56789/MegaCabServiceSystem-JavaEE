package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.BookingBO;
import lk.icbt.MegaCityCabSystem.bo.impl.BookingBOImpl;
import lk.icbt.MegaCityCabSystem.dto.BookingDTO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet(name = "BookingServlet", urlPatterns = {"/booking"})
public class BookingServlet extends HttpServlet {

    BookingBO bookingBO = new BookingBOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("booking servlet print msg");

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject obj = reader.readObject();
        String bookingID = obj.getString("bookingId");
        String customerId = obj.getString("customerId");
        String cabId = obj.getString("cabId");
        String registrationNo = obj.getString("registrationNo");
        String pickupDateTimeStr  = obj.getString("pickupDateTime");
        String pickupAddress = obj.getString("pickupAddress");
        String destination = obj.getString("destination");
        String distance = obj.getString("distance");
        String details = obj.getString("destinationDetails");

        // Convert pickupDateTimeStr to Timestamp
        LocalDateTime pickupDateTime = LocalDateTime.parse(pickupDateTimeStr );
        Timestamp pickupTimestamp = Timestamp.valueOf(pickupDateTime);

        BookingDTO bookingDTO = new BookingDTO(bookingID, customerId, cabId, registrationNo, null, null, null, null,
                destination, details, "pending", pickupTimestamp, pickupAddress, distance);

        if (bookingBO.addBooking(bookingDTO)){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 200);
            response.add("message", "Successfully Added");
            response.add("data", "");
            writer.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 500);
            response.add("message", "Can't add the booking");
            response.add("data", "");
            writer.print(response.build());
        }
    }
}
