package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.DriverBO;
import lk.icbt.MegaCityCabSystem.bo.impl.DriverBOImpl;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.dto.DriverDTO;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "DriverServlet", urlPatterns = {"/driver"})
public class DriverServlet extends HttpServlet {

    DriverBO driverBO = new DriverBOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("driver list for table");

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        ArrayList<DriverDTO> details = driverBO.getAllDriver();
        for (DriverDTO driverDTO : details){
            JsonObjectBuilder obj = Json.createObjectBuilder();
            obj.add("driverID", driverDTO.getDriverID());
            obj.add("driverName", driverDTO.getDriverName());
            obj.add("telephoneNo", driverDTO.getMobileNo());
            obj.add("license", driverDTO.getLicense());
            obj.add("experienceOfYear", driverDTO.getExperienceOfYear());
            obj.add("email", driverDTO.getEmail());
            obj.add("address", driverDTO.getAddress());
            obj.add("status", driverDTO.getStatus());

            arrayBuilder.add(obj.build());
        }

        writer.print(arrayBuilder.build());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("driver details for saved ");

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject obj = reader.readObject();
        String driverID = obj.getString("driverId");
        String driverName = obj.getString("driverName");
        String license = obj.getString("license");
        String address = obj.getString("address");
        String email = obj.getString("email");
        String contact = obj.getString("telephoneNo");
        String experience = obj.getString("experience");
        String status = obj.getString("status");

        DriverDTO driverDTO = new DriverDTO(driverID, driverName, contact, license, experience, email,
                address , status);

        if (driverBO.addDriver(driverDTO)){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 200);
            response.add("message", "Successfully Added");
            response.add("data", "");
            writer.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 500);
            response.add("message", "Can't add the driver");
            response.add("data", "");
            writer.print(response.build());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("driver details for update ");

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        JsonReader reader = Json.createReader(req.getReader());
        JsonObject obj = reader.readObject();
        String driverID = obj.getString("driverId");
        String driverName = obj.getString("driverName");
        String license = obj.getString("license");
        String address = obj.getString("address");
        String email = obj.getString("email");
        String contact = obj.getString("telephoneNo");
        String experience = obj.getString("experience");
        String status = obj.getString("status");

        DriverDTO driverDTO = new DriverDTO(driverID, driverName, contact, license, experience, email,
                address , status);

        if (driverBO.updateDriver(driverDTO)){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 200);
            response.add("message", "Successfuly Updated");
            response.add("data", "");
            writer.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 500);
            response.add("message", "Can't update driver");
            response.add("data", "");
            writer.print(response.build());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("driver details for delete ");

        resp.setContentType("application/json");

        String driverID = req.getParameter("driverID");
        System.out.println(driverID);

        PrintWriter writer = resp.getWriter();

        if (driverBO.deleteDriver(driverID)){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 200);
            response.add("message", "Successfuly deleted...");
            response.add("data", "");
            writer.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 500);
            response.add("message", "Wrong ID inserted...");
            response.add("data", "");
            writer.print(response.build());
        }

    }
}
