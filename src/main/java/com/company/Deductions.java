/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deductions;

/**
 *
 * @author DAYANG GWAPA
 */
public class Deductions {
    private double sssContribution;
    private double philhealthContribution;
    private double pagibigContribution;
    private double withholdingTax;
    private double otherDeductions;

    public double calculateTotalDeductions() {
        return sssContribution + philhealthContribution + pagibigContribution + withholdingTax + otherDeductions;
    }

    public static void main(String[] args) {
        Deductions ded = new Deductions();

        
        ded.sssContribution = 500.00;
        ded.philhealthContribution = 350.00;
        ded.pagibigContribution = 200.00;
        ded.withholdingTax = 1000.00;
        ded.otherDeductions = 150.00;

        double total = ded.calculateTotalDeductions();
        System.out.println("Total Deductions: " + total);
    }
}
