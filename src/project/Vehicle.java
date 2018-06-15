package payrollsystem;

public abstract class Vehicle {
    private String plateNumber;
    private String colour;
    private String type;

    Vehicle(String pPlate, String pColour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Vehicle (String type,String plateNumber, String colour){
        this.plateNumber = plateNumber;
        this.colour = colour;
        this.type=type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
}
