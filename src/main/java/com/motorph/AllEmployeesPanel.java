package com.motorph;

/**
 * @author Gavril pogi
 * based on my CP1 code
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.*;

public class AllEmployeesPanel extends JPanel {
    public AllEmployeesPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number",
                            "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position",
                            "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance",
                            "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        try (BufferedReader br = new BufferedReader(new FileReader("employee_data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == columns.length) {
                    // Format salary-related columns with ₱ symbol (assumes they're valid numbers otherwise wont work)
					// Allows for margin with use of commas
try {
    data[13] = "₱" + String.format("%,.2f", Double.parseDouble(data[13].replace(",", ""))); // Basic Salary
    data[14] = "₱" + String.format("%,.2f", Double.parseDouble(data[14].replace(",", ""))); // Rice Subsidy
    data[15] = "₱" + String.format("%,.2f", Double.parseDouble(data[15].replace(",", ""))); // Phone Allowance
    data[16] = "₱" + String.format("%,.2f", Double.parseDouble(data[16].replace(",", ""))); // Clothing Allowance
    data[17] = "₱" + String.format("%,.2f", Double.parseDouble(data[17].replace(",", ""))); // Gross Semi-monthly Rate
    data[18] = "₱" + String.format("%,.2f", Double.parseDouble(data[18].replace(",", ""))); // Hourly Rate
} catch (NumberFormatException e) {
    System.err.println("Error formatting currency fields: " + e.getMessage());
}
model.addRow(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // ok na yung resize neto pls...

        // Ok na to wag na-iadjust pero ikaw bahala ka wag mo lang i-commit
        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < columnModel.getColumnCount(); column++) {
            columnModel.getColumn(column).setPreferredWidth(150);
        }

        // Wrap table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200, 400)); // Adjust here

        add(scrollPane, BorderLayout.CENTER);
    }
}