package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.CabBO;
import lk.icbt.MegaCityCabSystem.bo.impl.CabBOImpl;
import lk.icbt.MegaCityCabSystem.dao.CabDAO;
import lk.icbt.MegaCityCabSystem.dto.CabDTO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "CabServlet", urlPatterns = {"/cab"})
@MultipartConfig // Required for file uploads
public class CabServlet extends HttpServlet {

    CabBO cabBO = new CabBOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("cab servlet print msg get method");
        super.doGet(req, resp);
    }

    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log("cab servlet print msg post method");
//
//        resp.setContentType("application/json");
//
//        PrintWriter writer = resp.getWriter();
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject obj = reader.readObject();
//        String cabID = obj.getString("cabId");
//        String cabType = obj.getString("model");
//        String mileage = obj.getString("mileage");
//        String availableStatus = obj.getString("status");
//        String price = obj.getString("price");
//        String capacity = obj.getString("capacity");
//
//        // Get the uploaded image file
//        Part imagePart = req.getPart("image");
//        InputStream imageInputStream = imagePart.getInputStream();
//
//        // Convert the image to a byte array
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        byte[] data = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = imageInputStream.read(data, 0, data.length)) != -1) {
//            buffer.write(data, 0, bytesRead);
//        }
//        byte[] imageBytes = buffer.toByteArray();
//
//        Double aDouble = Double.valueOf(price);
//
//        CabDTO cabDTO = new CabDTO(cabID, cabType, mileage, availableStatus, aDouble, capacity, "empty", imageBytes);
//
//        if (cabBO.addCab(cabDTO)){
//            JsonObjectBuilder response = Json.createObjectBuilder();
//            response.add("status", 200);
//            response.add("message", "Successfully Added");
//            response.add("data", "");
//            writer.print(response.build());
//        }else{
//            JsonObjectBuilder response = Json.createObjectBuilder();
//            response.add("status", 500);
//            response.add("message", "Can't add the cab");
//            response.add("data", "");
//            writer.print(response.build());
//        }
//    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("cab servlet print msg post method");

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        try {
            // Extract form fields
            String cabID = req.getParameter("cabId");
            String cabType = req.getParameter("model");
            String mileage = req.getParameter("mileage");
            String availableStatus = req.getParameter("status");
            String priceStr  = req.getParameter("price");
            String capacity = req.getParameter("capacity");

            // Get the uploaded image file
            Part imagePart = req.getPart("image");
            InputStream imageInputStream = imagePart.getInputStream();

            // Convert the image to a byte array
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int bytesRead;
            while ((bytesRead = imageInputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, bytesRead);
            }
            byte[] imageBytes = buffer.toByteArray();

            // Convert price to Double
            Double price  = Double.parseDouble(priceStr);

            // Create CabDTO object
            CabDTO cabDTO = new CabDTO(cabID, cabType, mileage, availableStatus, price, capacity, "empty", imageBytes);

            // Save cab using BO
            if (cabBO.addCab(cabDTO)) {
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 200);
                response.add("message", "Successfully Added");
                response.add("data", "");
                writer.print(response.build());
            } else {
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 500);
                response.add("message", "Can't add the cab");
                response.add("data", "");
                writer.print(response.build());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 500);
            response.add("message", "An error occurred: " + e.getMessage());
            response.add("data", "");
            writer.print(response.build());
        } finally {
            writer.flush();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("cab servlet print msg put method");
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("cab servlet print msg delete method");
        super.doDelete(req, resp);
    }
}
