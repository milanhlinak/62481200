package cz.milanhlinak.animal;

public abstract class Animal {

    private final String sound;

    public Animal(String sound) {
        this.sound = sound;
    }

    void makeSound() {
        System.out.println(this.sound);
    }
}