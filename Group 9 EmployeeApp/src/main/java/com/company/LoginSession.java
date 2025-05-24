/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsession;

/**
 *
 * @author DAYANG GWAPA
 */
public class LoginSession {
    private int id;
    private String loginTime;

    public boolean isLate() {
        String[] parts = loginTime.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour > 8) {
            return true;
        } else if (hour == 8 && minute > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LoginSession log = new LoginSession();
        log.id = 1001;
        log.loginTime = "08:00"; 

        boolean late = log.isLate();
        System.out.println("Is employee late? " + late);
    }
}