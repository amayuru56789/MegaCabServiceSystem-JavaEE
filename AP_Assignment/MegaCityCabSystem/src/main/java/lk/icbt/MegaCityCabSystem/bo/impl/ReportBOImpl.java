package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.ReportBO;
import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.BookingCommonDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ReportBOImpl implements ReportBO {

    BookingDAOImpl bookingDAO = new BookingDAOImpl();

    @Override
    public ByteArrayOutputStream generateBookingDetailSummeryPDF() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {

            List<BookingCommonDTO> reportSummeryList = bookingDAO.getAllSearchBookingList(null, null);

            // Load the JasperReport template from the resources folder
            InputStream templateStream = getClass().getClassLoader().getResourceAsStream("/reports/summeryreport/report_template.jrxml");

            // Compile the JasperReport template
            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);

            // Create a data source for the report
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportSummeryList);

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

            // Export the report to PDF and write it to the ByteArrayOutputStream
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        } catch (JRException e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating PDF", e);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return outputStream;
    }
}
