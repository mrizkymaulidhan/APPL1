package employee;

//***************************************************************************
//Commission.java      Author: M.Rizky
//
//Represents an employee that gets paid by the hours worked plus commission.
//***************************************************************************

public class Commission extends Hourly 
{
  double totalSales;
  double commissionRate;
  
  //----------------------------------------------------------------- 
  //  Sets up this commission employee using the specified information. 
  //-----------------------------------------------------------------
  public Commission(String eName, String eAddress, String ePhone,
          String socSecNumber, double rate, double commRate) 
  {
    super(eName, eAddress, ePhone, socSecNumber, rate);
    commissionRate = commRate;
  }
  
  //----------------------------------------------------------------- 
  //  Adds the specified amount of sales to this employee's
  //  total sales.
  //-----------------------------------------------------------------
  public void addSales(double totalSales) 
  {
    this.totalSales += totalSales;
  }
  
  //----------------------------------------------------------------- 
  //  Computes and returns the pay for this commission employee.
  //-----------------------------------------------------------------
  public double pay() 
  {
    double payment = super.pay();
    payment += totalSales * commissionRate;
    totalSales = 0;
    return payment;
  }
  
  //----------------------------------------------------------------- 
  //  Returns information about this commission employee as a string. 
  //-----------------------------------------------------------------
  public String toString() {
    String result = super.toString();
    result += "\nTotal Sales: " + totalSales; 
    return result;
  }
  
}