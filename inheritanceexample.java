// Parent class (Superclass)
class Animal {
    // Method in the parent class
    void sound() {
        System.out.println("This animal makes a sound");
    }
}

// Child class (Subclass)
class Dog extends Animal {
    // Method in the child class
    @Override
    void sound() {
        System.out.println("The dog barks");
    }
}

// Main class
public class InheritanceExample {
    public static void main(String[] args) {
        // Create an object of the parent class
        Animal animal = new Animal();
        animal.sound(); // Output: This animal makes a sound
        
        // Create an object of the child class
        Dog dog = new Dog();
        dog.sound(); // Output: The dog barks
    }
}
