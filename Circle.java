/** 
	Concrete subclass of GeometricObject that represents a circle.
	Provides implementations for getArea and getPerimeter.
*/

public class Circle extends GeometricObject {

    private double radius;

    // No-arg constructor creates a circle with radius 1.0
    public Circle() {
        this.radius = 1.0;
    }

    // Construct a circle with a specified radius 
    public Circle(double radius) {
        this.radius = radius;
    }

    // Construct a circle with radius, color, and filled status 
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Implement abstract method getArea() 
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // Implement abstract method getPerimeter()
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle(radius=" + radius + ")";
    }
}