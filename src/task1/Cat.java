package task1;

public class Cat extends Animal {
    private boolean bald;

    public void drinkMilk() {
        System.out.println("I'm drinking milk!");
    }
    public void purr() {
        System.out.println("I'm purring");
    }

    public Cat(String name, Integer age, boolean bald) {
        super(name, age);
        this.bald = bald;
    }
}
