package payrollsystem;
import static java.time.Clock.fixed;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JASWINDER
 */
public class PayrollSystem {

    public static void main(String[] args) {
        ArrayList<Employee> arrEmp = new ArrayList<Employee>();
        String varCont ="N";
        byte menuOption = 0;
        do{
                menuOption = showMenu();
            switch (menuOption) {
                case 1:
                    FullTime ft;
                    ft = readNewFullTime();
                    addEmployee(arrEmp, ft); // add full time employee to arraylist
                    break;
                case 2:
                    CommisionBased cb;
                    cb= readNewCommisionBased();
                    addEmployee(arrEmp, cb); // add full time employee to arraylist
                    break;
                  case 3:
                    FixedBased fb;
                    fb= readNewFixedBased();
                    addEmployee(arrEmp, fb); // add full time employee to arraylist
                    break;
                    
                    case 4:
                    Internship intern;
                    intern=readNewInternship();
                    addEmployee(arrEmp, intern); // add full time employee to arraylist
                    break;
                case 5:
                    calcPayroll(arrEmp);
                    break;
                default:
                    break;
            }
        } while (menuOption != 5);              
    }
    
    public static FullTime readNewFullTime (){
       
        int id = 0;
        String name = null;
        double sal = 0.0;
        double hourAndHalf = 0.0; // overtime
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: ");       id = kbd.nextInt();
        System.out.print("Enter Name: ");     name = kbd.next();
        System.out.print("Enter Salary: ");   sal = kbd.nextDouble();
        System.out.print("Enter Bonus: ");    hourAndHalf = kbd.nextDouble();
        
        FullTime ft1 = null;
        ft1 = new FullTime(id, name, sal, hourAndHalf, getVehicle());
        
        return ft1;
    }
    
    private static CommisionBased readNewCommisionBased() {
        int id = 0;
        String name = null;
        double sal = 0.0;
        double hourAndHalf = 0.0; 
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: ");         id = kbd.nextInt();
        System.out.print("Enter Name: ");     name = kbd.next();
        System.out.print("Enter Hourly Rate: ");  double rate = kbd.nextDouble();
        System.out.print("Enter Number of Hours Worked: ");   double hoursWorked = kbd.nextDouble();
        System.out.print("Enter commission: ");   double commission = kbd.nextDouble();
        
        Vehicle v1 = getVehicle();
        CommisionBased cm= null;
        cm= new CommisionBased(id, name, rate, hoursWorked,commission, v1);
        return cm;
    
    }

    private static FixedBased readNewFixedBased() {
       int id = 0;
        String name = null;
        double sal = 0.0;
        double hourAndHalf = 0.0; 
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: ");         id = kbd.nextInt();
        System.out.print("Enter Name: ");     name = kbd.next();
        System.out.print("Enter Hourly Rate: ");  double rate = kbd.nextDouble();
        System.out.print("Enter Number of Hours Worked: ");   double hoursWorked = kbd.nextDouble();
        System.out.print("Enter Fixed Ampount: ");   double fixed = kbd.nextDouble();
        
        Vehicle v1 = getVehicle();
        FixedBased fb = null;
        fb= new FixedBased(id, name, rate, hoursWorked,fixed, v1);
        
        return fb;
    } 
        public static Internship readNewInternship() {
        int id = 0;
        String name = null;
        double sal = 0.0;
        double hourAndHalf = 0.0; 
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: ");     id = kbd.nextInt();
        System.out.print("Enter Name: ");     name = kbd.next();
        System.out.print("Enter SchoolName: ");    String schoolname = kbd.next();
        System.out.print("Enter Hourly Rate: ");  double rate = kbd.nextDouble();
        System.out.print("Enter Number of Hours Worked: ");   double hoursWorked = kbd.nextDouble();
        
        Vehicle v1 = getVehicle();
        Internship intern = null;
        intern= new Internship(id, name,schoolname, rate, hoursWorked, v1);
        
        return intern;
    }
    public static byte showMenu () {
        
        byte menuOption = 0;
        Scanner kbd = new Scanner(System.in);
        
        System.out.println(""
        + "/* *************************************************/"
        + "\n/* 1. FullTime Employee"
        + "\n/* 2. PartTime-CommisionBased Employee"
        + "\n/* 3. PartTime-FixedBased Employee"        
        + "\n/* 4. Internship Employee" 
        + "\n/* 5. Calculate Payroll" 
        + "\n/* 6. Exit" 
        + "\n/* *************************************************/");
        System.out.print("Enter your option: ");            menuOption = kbd.nextByte();
        
        return menuOption;
    }
    
    public static Vehicle getVehicle() {
        
        Scanner kbd = new Scanner(System.in);
        String hasVehicle = "N";
        
        System.out.println("Does this employee have a vehicle? Y/N : ");hasVehicle = kbd.next();
        if (hasVehicle.equalsIgnoreCase("Y")) {
           System.out.println("Enter vehicle type(Car/Motorcycle): "); String type= kbd.next();;
            System.out.println("Enter plate number: "); String auxPlate = kbd.next();
            System.out.println("Enter vehicle colour: "); String auxColour = kbd.next();
            
            return (new Vehicle(type,auxPlate, auxColour) {});
        }
        else { 
            return (null);
        }
    }
    
    public static void addEmployee(ArrayList<Employee> pArrEmp, Employee pEmp) {
        pArrEmp.add(pEmp);
    }
    
    public static void calcPayroll (ArrayList<Employee> pArrEmp) {
        double totalCompanyPay = 0.0;
        double individualPay = 0.0;
        
            for (int i = 0; i<pArrEmp.size(); i++) {
                System.out.print("\n**********************\n");
                individualPay =(pArrEmp.get(i)).calcEarning();
                Vehicle v = (pArrEmp.get(i)).getVehicle();
                String hasVehicle;
                
                if (v == null)
                { 
                  hasVehicle = "No";
                  System.out.println("Employee Name: " +(pArrEmp.get(i)).getName());
                  System.out.println("Employee has no vehicle");
                }
                else
                {
                    if(v!=null)
                    {
                System.out.println("Employee Name: " +(pArrEmp.get(i)).getName());
                System.out.println("Employee Has Vehicle " +v.getType());
                System.out.println("Plate Number: " + v.getPlateNumber());
                System.out.println("Colour: " + v.getColour());
            }
          
                } 
                  
                System.out.println("Total Pay: " + individualPay);
                
                totalCompanyPay = totalCompanyPay + individualPay;
            }
        System.out.println("------------\nTotal payroll of the company: " + totalCompanyPay + "\n----");
    }

    
}
