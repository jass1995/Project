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
public class CommisionBased extends PartTime
{
    double commision;

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }
   
    public CommisionBased(int id, String name, double rate, double hoursWorked2,double commission, Vehicle v1) {
        super(id, name, rate, hoursWorked2, v1);
        this.commision = commission;
    }

    /**
     *
     * @return
     */
    @Override
    public double calcEarning() {
        
        System.out.println("CommisionBased employee.");
        return (this.getHoursWorked() * this.getRate())+this.getCommision();
    }

}
