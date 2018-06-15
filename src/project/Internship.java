/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

/**
 *
 * @author JASWINDER
 */
public class Internship extends Employee {

    private String SchoolName;
    private double rate;
    private double hoursWorked;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
   

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String SchoolName) {
        this.SchoolName = SchoolName;
    }
    
   public Internship(int id, String name,String schoolname, double rate,
                     double hoursWorked2, Vehicle v1) {
        super (id, name, v1);
        this.SchoolName=schoolname;
        this.rate = rate;
        this.hoursWorked = hoursWorked2;
    }
    public double calcEarning() {
        
       System.out.println("Internship Employee."); 
       System.out.println("School Name " +this.getSchoolName());
       return (this.getHoursWorked() * this.getRate());
      }
    
}
