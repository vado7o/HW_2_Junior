package task1;

public class Dog extends Animal {
    private Boolean hunting;
    public void sit() {
        System.out.println("I'm sitting");
    }
    public void lie() {
        System.out.println("I'm lying");
    }

    public void makeSound() {
        System.out.println(super.getName() + ": \"Gav, gav!\"");
    }

    public Dog(String name, Integer age, Boolean hunting) {
        super(name, age);
        this.hunting = hunting;
    }
}
