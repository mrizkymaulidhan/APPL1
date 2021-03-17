package paintingshapes;

//***************************************************************************
//Cylinder.java      Author: M.Rizky
//***************************************************************************
public class Cylinder extends Shape { 
    private double radius;  
    private double height;  
  
    public Cylinder(double r, double d) {
        super("Cylinder"); 
        this.radius = r;
        this.height = d;
    } 
    
    public double area() {
        return Math.PI * radius * radius * height;
    }
  
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}
