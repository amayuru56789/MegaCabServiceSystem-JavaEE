package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.BookingBO;
import lk.icbt.MegaCityCabSystem.bo.impl.BookingBOImpl;
import lk.icbt.MegaCityCabSystem.dto.BookingDTO;
import lk.icbt.MegaCityCabSystem.dto.DriverDTO;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        log("booking servlet search method print msg");
//
//        resp.setContentType("application/json");
//
//        PrintWriter writer = resp.getWriter();
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject obj = reader.readObject();
//        String bookingID = obj.getString("bookingId");
//
//        bookingBO.searchBooking(bookingID);

        log("driver list for table");

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        ArrayList<BookingDTO> details = bookingBO.getAllBooking();
        for (BookingDTO bookingDTO : details){
            JsonObjectBuilder obj = Json.createObjectBuilder();
            obj.add("bookingId", bookingDTO.getBookingId());
            obj.add("customerId", bookingDTO.getCustomerId());
            obj.add("cabId", bookingDTO.getCabId());
            obj.add("regNo", bookingDTO.getRegistrationNo());
//            obj.add("experienceOfYear", bookingDTO.getBookingDate());
//            obj.add("email", bookingDTO.getLastUpdatedDate());
//            obj.add("updatedTime", bookingDTO.getLastUpdatedTime());
            obj.add("destination", bookingDTO.getDestination());
            obj.add("destinationDetail", bookingDTO.getDestinationDetails());
            obj.add("status", bookingDTO.getActivityStatus());
//            obj.add("pickupDateTime", bookingDTO.getPickupDateTime());
            obj.add("pickupAddress", bookingDTO.getPickupAddress());
            obj.add("distance", bookingDTO.getDistance());

            arrayBuilder.add(obj.build());
        }

        writer.print(arrayBuilder.build());
    }
}
