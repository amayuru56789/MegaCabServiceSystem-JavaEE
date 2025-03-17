package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.CabBO;
import lk.icbt.MegaCityCabSystem.bo.impl.CabBOImpl;
import lk.icbt.MegaCityCabSystem.dto.CabDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

@WebServlet("/customer/cabs-view")
public class CabsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CabBO cabBO = new CabBOImpl();
        ArrayList<CabDTO> allCab = cabBO.getAllCab();

        // Convert each cab's image byte array to Base64
        for (CabDTO cab : allCab) {
            if (cab.getImgByte() != null) {
                String base64Image = Base64.getEncoder().encodeToString(cab.getImgByte());
                cab.setBase64Image(base64Image); // Add a new field in CabDTO to store the Base64 string
            } else {
                cab.setBase64Image(""); // Set an empty string if no image is available
            }
        }

        req.setAttribute("availableCabs", allCab);

        // Forward the request to the login.jsp page inside WEB-INF/auth
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/customer/available-cabs.jsp");
        dispatcher.forward(req, resp);

        String path = req.getPathInfo();
    }
}
