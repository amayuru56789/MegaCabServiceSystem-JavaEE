package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.UserBO;
import lk.icbt.MegaCityCabSystem.bo.impl.UserBOImpl;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log("user login print msg");
        UserBO userBO = new UserBOImpl();

        resp.setContentType("application/json");
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject obj = reader.readObject();
        PrintWriter writer = resp.getWriter();

        String userName = obj.getString("userName");
        String password = obj.getString("password");
        boolean equal = userBO.equalityUser(userName, password);
        if (equal){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 200);
            response.add("message", "Welcome " +userName+ "! You have successfully logged in.");
            response.add("data", JsonValue.NULL);
            writer.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 400);
            response.add("message", "Invalid credentials! Please check your username and password.");
            response.add("data", JsonValue.NULL);
            writer.print(response.build());
        }

    }
}
