/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employee;

/**
 *
 * @author DAYANG GWAPA
 */
public class Employee {
    private int id;
    private String name;
    private String email;
    private String hireDate;
    private String contractType;
    private String position;
    private String department;

    public void getEmployeeID() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Email: " + email);
    }
    
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.id = 10001;
        emp.name = "Dayangg";
        emp.email = "lrdababao@mmdc.mcl.edu.ph";
        emp.getEmployeeID();
        
    }
    
}