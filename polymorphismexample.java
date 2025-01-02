// Parent Class: Shape
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

// Child Class: Circle
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

// Child Class: Rectangle
class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Main Class
public class PolymorphismExample {
    public static void main(String[] args) {
        // Parent class reference pointing to child class objects
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        
        // Method calls
        shape1.draw(); // Calls the Circle's draw() method
        shape2.draw(); // Calls the Rectangle's draw() method
    }
}
