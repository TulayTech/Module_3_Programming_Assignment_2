/** 
	Concrete subclass of GeometricObject that represents a rectangle.
	Provides implementations for getArea and getPerimeter.
*/

public class Rectangle extends GeometricObject {

    private double width;
    private double height;

    // No-arg constructor creates a 1 x 1 rectangle
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Construct a rectangle with specified width and height 
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Construct a rectangle with width, height, color, and filled status 
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    // Getter for width 
    public double getWidth() {
        return width;
    }

    // Setter for width 
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter for height 
    public double getHeight() {
        return height;
    }

    // Setter for height 
    public void setHeight(double height) {
        this.height = height;
    }

    // Implement abstract method getArea() 
    @Override
    public double getArea() {
        return width * height;
    }

    // Implement abstract method getPerimeter() 
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle(width=" + width + ", height=" + height + ")";
    }
}