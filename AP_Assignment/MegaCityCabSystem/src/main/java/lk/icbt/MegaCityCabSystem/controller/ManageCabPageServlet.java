package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.dao.impl.DriverDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CommonDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet("/admin/bookings")
public class ManageCabPageServlet extends HttpServlet {

    DriverDAOImpl dao = new DriverDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CommonDTO> drivers = null;
        try {
            drivers = dao.getAllDriverDes();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("drivers", drivers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/admin/manage-cab.jsp");
        dispatcher.forward(req, resp);

        String path = req.getPathInfo();
    }
}
