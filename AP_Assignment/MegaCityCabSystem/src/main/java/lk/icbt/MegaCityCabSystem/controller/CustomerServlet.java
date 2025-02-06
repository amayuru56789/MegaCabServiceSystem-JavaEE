package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.CustomerBO;
import lk.icbt.MegaCityCabSystem.bo.impl.CustomerBOImpl;
import lk.icbt.MegaCityCabSystem.dao.CustomerDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.CustomerDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;

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

        CustomerDTO customerDTO = new CustomerDTO(customerID, customerName, address, nic, email, contact,
                "null", new Date());

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
}
