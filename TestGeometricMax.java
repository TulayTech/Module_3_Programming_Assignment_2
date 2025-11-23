/**
	 Test program for Exercise 13.5. Uses GeometricObject.max
	 to find the larger of two circles and two rectangles.
*/

public class TestGeometricMax {
    public static void main(String[] args) {

        // Two circles with different radii
        GeometricObject circle1 = new Circle(3.0);   // area ~ 28.27
        GeometricObject circle2 = new Circle(5.0);   // area ~ 78.54

        GeometricObject largerCircle = GeometricObject.max(circle1, circle2);
        System.out.println("Larger circle: " + largerCircle);
        System.out.println("Area: " + largerCircle.getArea());
        System.out.println();

        // Two rectangles with different dimensions
        GeometricObject rect1 = new Rectangle(4.0, 6.0); // area = 24
        GeometricObject rect2 = new Rectangle(2.0, 10.0); // area = 20

        GeometricObject largerRectangle = GeometricObject.max(rect1, rect2);
        System.out.println("Larger rectangle: " + largerRectangle);
        System.out.println("Area: " + largerRectangle.getArea());
    }
}