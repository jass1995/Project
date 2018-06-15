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
public class FixedBased extends PartTime {
    double fixed;
    public FixedBased(int id, String name, double rate, double hoursWorked2,double fixed, Vehicle v1) {
        super(id, name, rate, hoursWorked2, v1);
        this.fixed=fixed;
    }

    
     public double calcEarning() {
        
        System.out.println("FixedBased employee."); 
        return (this.getHoursWorked() * this.getRate())+ this.getFixed();
    }

    public double getFixed() {
        return fixed;
    }

    public void setFixed(double fixed) {
        this.fixed = fixed;
    }

}
