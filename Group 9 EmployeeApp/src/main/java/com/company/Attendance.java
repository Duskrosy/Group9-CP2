/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.attendance;

/**
 *
 * @author DAYANG GWAPA
 */
public class Attendance {
    private int id;
    private String date;
    private String timeIn;
    private String timeOut;

    public double calculateWorkedHours() {
        
        return 8.0;
    }

    
    public static void main(String[] args) {
        Attendance att = new Attendance();
        att.id = 1001;
        att.date = "2025-05-19";
        att.timeIn = "08:00";
        att.timeOut = "17:00";

        double hours = att.calculateWorkedHours();
        System.out.println("Worked Hours: " + 8);
    }
}
