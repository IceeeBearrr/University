/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Janice
 */
public class TutorManagement {
    private String tutorID;
    private String name;
    private String gender;
    private String email;
    private String phoneNumber;          
    private String department;          //group by department
    private String status;
    private double salary;
    


    public TutorManagement() {
    }
    
    public TutorManagement(String tutorID, String name, String gender, String email, String phoneNumber, String department, String status, double salary) {
        this.tutorID = tutorID;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.status = status;
        this.salary = salary;
    }

    //tutorID
    public String getTutorID() {
        return tutorID;
    }

    public void setTutorID(String tutorID) {
        this.tutorID = tutorID;
    }
    
    //name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //gender
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    //email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //department
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    //status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    //salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return String.format("║ %-10s │ %-20s │ %-6s │ %-26s │ %-14s │ %-18s │ %-16s │ %.2f    ║", tutorID, name, gender, email, phoneNumber, department, status, salary);
    }

}
