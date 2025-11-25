/**
	Abstract base class for geometric shapes.
	Implements Comparable<GeometricObject> and provides a static max method
	to return the larger of two geometric objects based on area.
*/

public abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "white";
    private boolean filled;

    // Default constructor (creates white, unfilled object)
    protected GeometricObject() {
    }

    // Construct a geometric object with specified color/filled 
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getter method for color 
    public String getColor() {
        return color;
    }

    // Setter method for color 
    public void setColor(String color) {
        this.color = color;
    }

    // Getter method for filled (boolean uses "is" prefix) 
    public boolean isFilled() {
        return filled;
    }

    // Setter method for filled 
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Abstract method getArea (must be implemented by subclass) 
    public abstract double getArea();

    // Abstract method getPerimeter (must be implemented by subclass)
    public abstract double getPerimeter();

    /**
     * Implementation of Comparable<GeometricObject>.
     * Compares two geometric objects by their areas.
     */
    @Override
    public int compareTo(GeometricObject other) {
        double thisArea = this.getArea();
        double otherArea = other.getArea();

        if (thisArea < otherArea) {
            return -1;
        } else if (thisArea > otherArea) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Static utility method that returns the larger of two
     * GeometricObject instances based on area.
     */
    public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
        // If areas are equal or obj1 is larger, return obj1; otherwise, return obj2
        if (obj1.compareTo(obj2) >= 0) {
            return obj1;
        } else {
            return obj2;
        }
    }
}