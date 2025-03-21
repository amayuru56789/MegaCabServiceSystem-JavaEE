package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.ReportBO;
import lk.icbt.MegaCityCabSystem.bo.impl.ReportBOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/generate-report")
public class ReportServlet extends HttpServlet {

    // Create an instance of the business object
    ReportBO reportBO = new ReportBOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Set response headers for PDF download
        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "attachment; filename=\"bookings_report.pdf\"");

        try {

            // Generate the PDF using the business layer
            ByteArrayOutputStream pdfStream = reportBO.generateBookingDetailSummeryPDF();

            // Write the PDF to the response output stream
            OutputStream out = resp.getOutputStream();
            pdfStream.writeTo(out);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        }
    }
}
