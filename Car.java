import java.awt.*;
/*
Car as superclass and the different models as subclasses (inheritance)

The Open-Closed Principle (OCP) states:
Software entities should be open for extension but closed for modification.

In the original structure, if you wanted to add another car model,
you might end up copying methods and attributes from existing classes.

With the new structure, you can simply create another subclass such as BMW for example.
 */

public abstract class Car {
    // The shared attributes of a car:
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car, not final because we want to be able to change value
    private Color color; // Color of the car, not final because we want to be able to change value
    private final String modelName; // The car model name

    // Conductor:
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }
    // Getters (methods to call the different values):
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    // Setters and the common functionalities of a car (to prevent duplication of code):
    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected double speedFactor() { return getCurrentSpeed();}

    protected void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to assignment pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to assignment pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}