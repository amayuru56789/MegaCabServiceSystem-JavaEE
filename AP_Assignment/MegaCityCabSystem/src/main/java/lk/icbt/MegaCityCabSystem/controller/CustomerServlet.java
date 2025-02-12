package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.CustomerBO;
import lk.icbt.MegaCityCabSystem.bo.impl.CustomerBOImpl;
import lk.icbt.MegaCityCabSystem.dao.CustomerDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.CustomerDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    CustomerBO customerBO = new CustomerBOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("customer servlet print msg");

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject obj = reader.readObject();
        String customerID = obj.getString("customerId");
        String customerName = obj.getString("customerName");
        String address = obj.getString("address");
        String email = obj.getString("email");
        String contact = obj.getString("telephoneNo");
        String nic = obj.getString("nic");
        String user = obj.getString("user");
        String password = obj.getString("password");

        CustomerDTO customerDTO = new CustomerDTO(customerID, customerName, address, nic, email, contact,
                user, password, "null", new Date(), null, new Date(), null);

        if (customerBO.registrationCustomer(customerDTO)){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 200);
            response.add("message", "Successfully Added");
            response.add("data", "");
            writer.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 500);
            response.add("message", "Can't add the user");
            response.add("data", "");
            writer.print(response.build());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        //System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();

        /*get user information from json Request Using JsonReader */
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        String customerID = jsonObject.getString("customerId");
        String customerName = jsonObject.getString("customerName");
        String address = jsonObject.getString("address");
        String email = jsonObject.getString("email");
        String contact = jsonObject.getString("telephoneNo");
        String nic = jsonObject.getString("nic");
        String user = jsonObject.getString("user");
        String password = jsonObject.getString("password");
        /*System.out.println(userID+" "+userName+" "+address+" "+email);*/

        CustomerDTO customerDTO = new CustomerDTO(customerID, customerName, address, nic, email, contact, user, password,
                "null", null, null, new Date(), null);

        try {
            if (customerBO.updateCustomer(customerDTO)){
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 200);
                response.add("message", "Successfuly Updated");
                response.add("data", "");
                writer.print(response.build());
            }else{
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 500);
                response.add("message", "Can't update user");
                response.add("data", "");
                writer.print(response.build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        //get customerID Using getParameter Method
        String customerID = req.getParameter("customerID");
        System.out.println(customerID);

        //System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();

        try {
            if (customerBO.deleteCustomer(customerID)){
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        ArrayList<CustomerDTO> details = customerBO.getAllCustomer();
        for (CustomerDTO customerDTO : details){
            JsonObjectBuilder obj = Json.createObjectBuilder();
            obj.add("customerID", customerDTO.getCustomerId());
            obj.add("customerName", customerDTO.getCustomerName());
            obj.add("address", customerDTO.getAddress());
            obj.add("email", customerDTO.getEmail());
            obj.add("telephoneNo", customerDTO.getTelephoneNo());
            obj.add("nic", customerDTO.getNic());
//            obj.add("password", customerDTO.getPassword());

            arrayBuilder.add(obj.build());
        }

        writer.print(arrayBuilder.build());
    }
}
